package com.weather.model.Dto;

import com.weather.model.Temperature;

import java.util.List;

/**
 * Created by martanase on 11/25/2016.
 */
public class CityDto {

    private Long id;

    private String name;

    private String country;

    private List<Temperature> dailyTemperatures;

    public CityDto() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Temperature> getDailyTemperatures() {
        return dailyTemperatures;
    }

    public void setDailyTemperatures(List<Temperature> dailyTemperatures) {
        this.dailyTemperatures = dailyTemperatures;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", dailyTemperatures=" + dailyTemperatures +
                '}';
    }
}
