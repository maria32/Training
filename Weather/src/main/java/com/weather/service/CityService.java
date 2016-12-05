package com.weather.service;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by martanase on 11/24/2016.
 */
public interface CityService {

    CityDto create(JSONObject jsonObject);

    CityDto update(City city, JSONObject jsonObject);

    City getOne(Long id);

    CityDto getOneByName(String cityName);

    List<City> getAll();

    List<CityDto> getAllDto();

    List<CityDto> getAllCitiesFotUser(Long userId);

    void delete(Long id);
}
