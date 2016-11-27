package com.weather.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by martanase on 11/22/2016.
 */

@Entity
@Table(name = "temperatures")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
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

    public City getIdCity() {
        return city;
    }

    public void setIdCity(City city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", city=" + city +
                ", temperature=" + temperature +
                ", day=" + day +
                '}';
    }
}
