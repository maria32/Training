package com.weather.service.Impl;

import com.weather.model.City;
import com.weather.model.Temperature;
import com.weather.repository.TemperatureRepository;
import com.weather.service.TemperatureService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by martanase on 11/24/2016.
 */
@Service
@Transactional
public class TemperatureServiceImpl implements com.weather.service.TemperatureService {

    @Autowired
    TemperatureRepository temperatureRepository;

    @Override
    public List<Temperature> getTemperaturesForCity(Long cityId){
        return temperatureRepository.getTemperaturesByCityId(cityId);
    }

    @Override
    public List<Temperature> createTemperatures(City city, JSONObject jsonObject){
            List<Temperature> temperatures = new ArrayList<>();
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            //temperature for today (/ first day)
            if (jsonArray.length() % 8 != 0)
                temperatures.add(getTemperatureForTheDay(0, jsonArray.length() % 8 - 1, city, jsonObject));
            //temperatures for the rest of the days
            for (int i = jsonArray.length() % 8; i < jsonArray.length(); i = i + 8) {
                temperatures.add(getTemperatureForTheDay(i, i + 7, city, jsonObject));
            }
            temperatureRepository.save(temperatures);
            return temperatures;

    }

    private Temperature getTemperatureForTheDay(int start, int end, City city, JSONObject jsonObject){

        Temperature temp = new Temperature();
        SimpleDateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd");
        temp.setCity(city);
        try {
            temp.setDay(toFormat.parse(jsonObject.getJSONArray("list").getJSONObject(start).get("dt_txt").toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //humidity and weather must be set inside for for realistic results, but it's fine like this, too
        temp.setHumidity(Double.parseDouble(jsonObject.getJSONArray("list").getJSONObject(start).getJSONObject("main").get("humidity").toString()));
        temp.setWeather(jsonObject.getJSONArray("list").getJSONObject(start).getJSONArray("weather").getJSONObject(0).get("main").toString());

        double temp_min = Double.parseDouble(jsonObject.getJSONArray("list").getJSONObject(start).getJSONObject("main").get("temp_min").toString());
        double temp_max = Double.parseDouble(jsonObject.getJSONArray("list").getJSONObject(start).getJSONObject("main").get("temp_max").toString());
        for(int i = start; i <= end; i++){
            JSONObject listElement = jsonObject.getJSONArray("list").getJSONObject(i);

            if(temp_min > Double.parseDouble(listElement.getJSONObject("main").get("temp_min").toString())){
                temp_min = Double.parseDouble(listElement.getJSONObject("main").get("temp_min").toString());
            }
            if(temp_max < Double.parseDouble(listElement.getJSONObject("main").get("temp_max").toString())){
                temp_max = Double.parseDouble(listElement.getJSONObject("main").get("temp_max").toString());
            }
        }
        temp.setTempMin(Math.round(temp_min));
        temp.setTempMax(Math.round(temp_max));

        return temp;
    }

    @Override
    public void deleteTemperatures(Long cityId) {
        temperatureRepository.deleteByCityId(cityId);
    }

}
