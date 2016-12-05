package com.weather.service;

import com.weather.model.City;
import com.weather.model.Temperature;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by martanase on 11/27/2016.
 */
public interface TemperatureService {
    List<Temperature> getTemperaturesForCity(Long cityId);

    List<Temperature> createTemperatures(City city, JSONObject jsonObject);

    void deleteTemperatures(Long cityId);
}
