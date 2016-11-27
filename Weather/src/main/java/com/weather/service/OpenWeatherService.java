package com.weather.service;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;

/**
 * Created by martanase on 11/23/2016.
 */
public interface OpenWeatherService {

    CityDto getWeatherDetails(String cityName);

}
