package com.weather.repository;

import com.weather.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by martanase on 11/25/2016.
 */
@Repository
public interface CityRepository extends CrudRepository<City, Long>{

    City findByName(String cityName);

    City findOneByName(String cityName);

}
