package com.weather.service.Impl;

import com.weather.exception.ResourceNotFoundException;
import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import com.weather.model.Temperature;
import com.weather.model.User;
import com.weather.repository.CityRepository;
import com.weather.repository.UserRepository;
import com.weather.service.CityService;
import com.weather.service.OpenWeatherService;
import com.weather.service.TemperatureService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by martanase on 11/24/2016.
 */

@Service
@Transactional
public class CityServiceImpl implements CityService{

    @Autowired
    CityRepository cityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TemperatureService temperatureService;

    @Autowired
    OpenWeatherService openWeatherService;

    public CityDto create(JSONObject jsonObject){

        City city  = new City();

        //set city attributes
        Long cityId = new Long((Integer) jsonObject.getJSONObject("city").get("id"));
        city.setId(cityId);
        city.setJson(jsonObject.toString());
        city.setName((String) jsonObject.getJSONObject("city").get("name"));
        city.setCountry((String) jsonObject.getJSONObject("city").get("country"));
        city.setDateOfUpdate(new Date());

        city.setDailyTemperatures(temperatureService.createTemperatures(city, jsonObject));
        return populateFromCity(cityRepository.save(city));
    }

    @Override
    public CityDto update(City city, JSONObject jsonObject) {
        temperatureService.deleteTemperatures(city.getId());
        city.setDailyTemperatures(temperatureService.createTemperatures(city, jsonObject));
        city.setJson(jsonObject.toString());
        city.setDateOfUpdate(new Date());
        cityRepository.save(city);
        return populateFromCity(city);
    }

    @Override
    public City getOne(Long id) {
        City city = id == null ? null : cityRepository.findOne(id);
        if(city == null)
            throw new ResourceNotFoundException();
        return city;
    }

    @Override
    public CityDto getOneByName(String cityName) {
        City city = cityName == null ? null : cityRepository.findOneByName(cityName);
        if(city == null)
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(!dateFormat.format(city.getDateOfUpdate()).equals(dateFormat.format(new Date()))) {

            try {
                JSONObject json = openWeatherService.getJsonFromUrl(cityName);
                update(city, json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return populateFromCity(city);
    }

    @Override
    public List<CityDto> getAllCitiesFotUser(Long userId) {
        User user = userId == null ? null : userRepository.findOne(userId);
        if(user != null) {
            List<CityDto> citiesDto = new ArrayList<>();
            for (City city : user.getCities()) {
                citiesDto.add(populateFromCity(city));
            }
            return citiesDto;
        }
        return null;
    }

    @Override
    public List<CityDto> getAllDto() {
        Iterator<City> allCitiesFromDb =  cityRepository.findAll().iterator();
        List<CityDto> allUsersDto = new ArrayList<>();
        while (allCitiesFromDb.hasNext()){
            allUsersDto.add(populateFromCity(allCitiesFromDb.next()));
        }
        return allUsersDto;
    }

    @Override
    public List<City> getAll() {
        Iterator<City> allCitiesFromDb =  cityRepository.findAll().iterator();
        List<City> allCities = new ArrayList<>();
        while (allCitiesFromDb.hasNext()){
            allCities.add(allCitiesFromDb.next());
        }
        return allCities;
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(getOne(id));
    }

    private CityDto populateFromCity(City city){
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setCountry(city.getCountry());
        cityDto.setDailyTemperatures(city.getDailyTemperatures());
        return cityDto;
    }
}
