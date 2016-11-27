package com.weather.service.Impl;

import com.weather.model.City;
import com.weather.repository.CityRepository;
import com.weather.repository.UserRepository;
import com.weather.exception.ResourceAlreadyExistsException;
import com.weather.exception.ResourceNotFoundException;
import com.weather.model.User;
import com.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by martanase on 11/22/2016.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public User create(User user) {
        User existingUser = user.getId() == null ? null : userRepository.findOne(user.getId());
        User existingUsername = user.getUsername() == null ? null : userRepository.findByUsername(user.getUsername());
        if(existingUser != null || existingUsername != null)
            throw new ResourceAlreadyExistsException();
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User existingUser = getOne(user.getId());
        User existingUsername = userRepository.findByUsername(user.getUsername());
        if(existingUsername != null && existingUser.getUsername() != existingUsername.getUsername())
            throw new ResourceAlreadyExistsException();
        return user;

    }

    @Override
    public User getOne(Long id) {
        User user = id == null ? null : userRepository.findOne(id);
        if(user == null)
            throw new ResourceNotFoundException();
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getOne(id));
    }

    @Override
    public User addCityToUser(Long userId, String cityName) {
        User user = userId == null ? null : userRepository.findOne(userId);
        City city = cityName == null ? null : cityRepository.findByName(cityName);
        if (user != null && city != null){
            List<City> citiesList = new ArrayList<>();
            citiesList = user.getCities();
            if(!existsCityInList(user, city))
                citiesList.add(city);
            user.setCities(citiesList);
            userRepository.save(user);
        }
        return user;
    }

    /*check if city already exists to user's list of cities*/
    private boolean existsCityInList(User user, City city){
        if(user.getCities().contains(city))
            return true;
        return false;

    }
}
