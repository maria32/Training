package com.weather.model.Dto;

import java.util.List;

/**
 * Created by martanase on 11/25/2016.
 */
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String password;
    private List<CityDto> cities;

    public UserDto() {
    }

    public UserDto(Long id, String name, String username, String password, List<CityDto> cities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cities=" + cities +
                '}';
    }
}
