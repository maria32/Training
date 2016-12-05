package com.weather.repository;

import com.weather.model.Temperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martanase on 11/26/2016.
 */
@Repository
public interface TemperatureRepository extends CrudRepository<Temperature, Long>{

    List<Temperature> getTemperaturesByCityId(Long cityId);

    void deleteByCityId(Long cityId);
}
