package com.weather.execute;

import com.weather.model.City;
import com.weather.repository.TemperatureRepository;
import com.weather.service.CityService;
import com.weather.service.OpenWeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by martanase on 12/5/2016.
 */
@Component
@Transactional
public class RefreshDataBase{

    @Autowired
    TemperatureRepository temperatureRepository;

    @Autowired
    CityService cityService;

    @Autowired
    OpenWeatherService openWeatherService;


    @Scheduled(cron = "${cron.RefreshDataBase.expression}")
    public void run() {

        System.out.println("Execute RefreshDataBase started");
        List<City> cities = cityService.getAll();
        for(City city: cities){
            String cityName = city.getName().replaceAll(" ", "%20").concat("," + city.getCountry());
            System.out.println("\t" + cityName);
            try {
                JSONObject json = openWeatherService.getJsonFromUrl(cityName);
                cityService.update(city, json);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
