package com.weather.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by martanase on 11/22/2016.
 */

@Entity
@Table(name = "temperatures")
public class Temperature implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "city_id")
    private City city;

    private Date day;

    private double temperature;

    private double humidity;

    private String weather; /* id=500 "Rain", id=800 "Clear", ""*/

    public Temperature() {
    }

    public Temperature(Long id, City city, int temperature, Date day) {
        this.id = id;
        this.city = city;
        this.temperature = temperature;
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", city=" + city +
                ", day=" + day +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", weather='" + weather + '\'' +
                '}';
    }
}
