package com.weather.repository;

import com.weather.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martanase on 11/22/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    User findByUsername(String username);
}
