package com.weather.service.Impl;

import com.weather.model.City;
import com.weather.model.Dto.CityDto;
import com.weather.model.Dto.UserDto;
import com.weather.repository.CityRepository;
import com.weather.repository.UserRepository;
import com.weather.exception.ResourceAlreadyExistsException;
import com.weather.exception.ResourceNotFoundException;
import com.weather.model.User;
import com.weather.service.CityService;
import com.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        User existingUser = user == null ? null : userRepository.findOne(user.getId());
        User existingUsername = userRepository.findByUsername(user.getUsername());
        if(existingUsername != null && existingUser.getUsername() != existingUsername.getUsername())
            throw new ResourceAlreadyExistsException();
        return user;

    }

    @Override
    public UserDto getOne(Long id) {
        User user = id == null ? null : userRepository.findOne(id);
        if(user == null)
            throw new ResourceNotFoundException();
        return populateUserDto(user);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = users.stream().map(this::populateUserDto).collect(Collectors.toList());
        return usersDto;
    }



    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.findOne(id));
    }

    @Override
    public User checkCredentials(User user) {
        User userByUsername;
        if(user != null && user.getUsername() != null && user.getPassword() != null){
            userByUsername = userRepository.findByUsername(user.getUsername());
            if(userByUsername != null && userByUsername.getPassword().equals(user.getPassword()))
                return userByUsername;
        }
        return null;
    }

    @Override
    public CityDto addCityToUser(Long userId, String cityName) {
        User user = userId == null ? null : userRepository.findOne(userId);
        City city = cityName == null ? null : cityRepository.findByName(cityName);

        if (user != null && city != null){
            List<City> citiesList = user.getCities();
            if(!existsCityInList(user, city)) {
                citiesList.add(city);
                user.setCities(citiesList);
                userRepository.save(user);

                return populateCityDto(city);
            }
        }
        return null;
    }

    /*check if city already exists to user's list of cities*/
    private boolean existsCityInList(User user, City city){
        if(user.getCities().contains(city)){
            return true;
        }
        return false;

    }

    @Override
    public void deleteCityFromUserByCityName(Long id, String cityName) {
        User user = id == null ? null : userRepository.findOne(id);
        if(user != null  && cityName != null) {
            user.getCities().remove(cityRepository.findByName(cityName));
            userRepository.save(user);
        }
    }
    private UserDto populateUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        List<CityDto> citiesDto = user.getCities().stream().map(this::populateCityDto).collect(Collectors.toList());
        userDto.setCities(citiesDto);

        return userDto;
    }

    private CityDto populateCityDto(City city){
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setCountry(city.getCountry());
        cityDto.setDailyTemperatures(city.getDailyTemperatures());

        return cityDto;
    }

}
