package com.weather.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by martanase on 11/22/2016.
 */
@Entity
@Table(name = "cities")
public class City implements Serializable{

    @Id
    private Long id;

    private String name;

    private String country;

    @Column(columnDefinition = "TEXT")
    private String json;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Temperature> dailyTemperatures;


    @JsonBackReference
    @ManyToMany(mappedBy = "cities", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> users;

    @Column(name = "date_of_update", columnDefinition = "DATE")
    private Date dateOfUpdate;

    public City() {
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

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public List<Temperature> getDailyTemperatures() {
        return dailyTemperatures;
    }

    public void setDailyTemperatures(List<Temperature> dailyTemperatures) {
        this.dailyTemperatures = dailyTemperatures;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", json='" + json + '\'' +
                ", dailyTemperatures=" + dailyTemperatures +
                ", dateOfUpdate=" + dateOfUpdate +
                '}';
    }
}
