package com.weather.service;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by martanase on 11/24/2016.
 */
public interface CityService {

    CityDto create(JSONObject jsonObject);

    City update(JSONObject jsonObject);

    City getOne(Long id);

    CityDto getOneByName(String cityName);

    List<CityDto> getAllDto();

    List<City> getAllCitiesFotUser(Long userId);

    void delete(Long id);
}
