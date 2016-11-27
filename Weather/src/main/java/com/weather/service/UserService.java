package com.weather.service;

import com.weather.model.City;
import com.weather.model.User;

import java.util.List;

/**
 * Created by martanase on 11/22/2016.
 */

public interface UserService{

    User create(User user);

    User update(User user);

    User getOne(Long id);

    List<User> getUsers();

    void delete(Long id);

    User addCityToUser(Long userId, String cityName);

}
