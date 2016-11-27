package com.weather.service.Impl;

import com.weather.model.Temperature;
import com.weather.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martanase on 11/24/2016.
 */
@Service
@Transactional
public class TemperatureServiceImpl {

    @Autowired
    TemperatureRepository temperatureRepository;

    public List<Temperature> getTemperaturesForCity(Long cityId){
        return temperatureRepository.getTemperaturesByCityId(cityId);
    }
}
