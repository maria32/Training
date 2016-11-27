package com.weather.controller;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import com.weather.service.CityService;
import com.weather.service.OpenWeatherService;
import com.weather.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martanase on 11/25/2016.
 */

@RestController
@RequestMapping("/cities")

public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private OpenWeatherService openWeatherService;

//    @Autowired
//    private TemperatureService temperatureService;

    /*create for city is done in WeatherController*/

    @RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
    @ResponseBody
    public CityDto getOne(@PathVariable("cityName") String cityName) { return cityService.getOneByName(cityName); }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<CityDto> getAll() { return cityService.getAllDto(); }



}
