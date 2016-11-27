package com.weather.controller;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import com.weather.service.OpenWeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martanase on 11/23/2016.
 */

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private OpenWeatherService weatherService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CityDto createCity(@RequestBody String cityName) {
        return weatherService.getWeatherDetails(cityName);
    }


}
