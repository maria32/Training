package com.weather.controller;

import com.weather.model.City;
import com.weather.model.User;
import com.weather.service.CityService;
import com.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martanase on 11/22/2016.
 */
@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public User create(@RequestBody User user) { return userService.create(user);}

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User update(@PathVariable("id") Long id, @RequestBody User user){
        //user.setId(id);
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getOne(@PathVariable("id") Long id) { return userService.getOne(id); }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll() {
        return userService.getUsers(); }

    @RequestMapping(value = "/{id}/city/{cityName}", method = RequestMethod.POST)
    @ResponseBody
    public User addCityToUser(@PathVariable("id") Long userId, @PathVariable("cityName") String cityName){
        return userService.addCityToUser(userId, cityName);
    }

    @RequestMapping(value = "/{userId}/cities", method = RequestMethod.GET)
    @ResponseBody
    public List<City> getAllCitiesForUser(@PathVariable("userId") Long userId) {
        return cityService.getAllCitiesFotUser(userId); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") Long id) { userService.delete(id); }



}
