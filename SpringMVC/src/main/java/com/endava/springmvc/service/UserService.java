package com.endava.springmvc.service;


import com.endava.springmvc.model.User;

import java.util.List;

/**
 * Created by martanase on 11/18/2016.
 */
public interface UserService {

    User getUserById(Integer id);

    List<User> getAllUsers();

    void deleteUserById(Integer id);

    User updateUser(User user);

    User create(User user);
}
