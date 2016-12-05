package com.weather.service;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import com.weather.model.Dto.UserDto;
import com.weather.model.User;

import java.util.List;

/**
 * Created by martanase on 11/22/2016.
 */

public interface UserService{

    User create(User user);

    User update(User user);

    UserDto getOne(Long id);

    List<UserDto> getUsers();

    void delete(Long id);

    CityDto addCityToUser(Long userId, String cityName);

    User checkCredentials(User user);

    void deleteCityFromUserByCityName(Long id, String cityName);
}
