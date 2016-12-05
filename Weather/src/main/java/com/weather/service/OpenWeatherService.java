package com.weather.service;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by martanase on 11/23/2016.
 */
public interface OpenWeatherService {

    CityDto getWeatherDetails(String cityName);

    JSONObject getJsonFromUrl(String cityName) throws IOException;

}
