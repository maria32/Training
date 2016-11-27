package com.weather.service;

import com.weather.model.Temperature;

import java.util.List;

/**
 * Created by martanase on 11/24/2016.
 */
public interface TemperatureService {

    public List<Temperature> getTemperaturesForCity(Long cityId);

}
