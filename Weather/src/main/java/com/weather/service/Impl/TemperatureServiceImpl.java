package com.weather.service.Impl;

import com.weather.model.City;
import com.weather.model.Temperature;
import com.weather.repository.TemperatureRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.java2d.pipe.SpanShapeRenderer;

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
    public void createTemperatures(City city, JSONObject jsonObject){
        System.out.println("\n\t***TemperatureService: createTemperatures");
        List<Temperature> temperatures = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        JSONArray jsonArray = jsonObject.getJSONArray("list");
        for(int i = 0; i<=4; i++){
            Temperature temp = new Temperature();
            temp.setCity(city);
            try {
                temp.setDay(format.parse(jsonArray.getJSONObject(i*8).get("dt_txt").toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            temp.setHumidity(Double.parseDouble(jsonArray.getJSONObject(i*8).getJSONObject("main").get("humidity").toString()));
            temp.setTemperature(Double.parseDouble(jsonArray.getJSONObject(i*8).getJSONObject("main").get("temp").toString()));
            temp.setWeather(jsonArray.getJSONObject(i*8).getJSONArray("weather").getJSONObject(0).get("main").toString());
            temperatures.add(temp);
        }
        temperatureRepository.save(temperatures);
        System.out.println(jsonObject.getJSONArray("list").get(0));
    }
}
