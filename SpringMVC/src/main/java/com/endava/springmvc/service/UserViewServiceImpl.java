package com.endava.springmvc.service;

import com.endava.springmvc.dtos.UserDto;
import com.endava.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by martanase on 11/22/2016.
 */
@Service
public class UserViewServiceImpl implements  UserViewService{

    @Autowired
    private UserService userService;

    public UserDto findById(Integer id) {
        User user = userService.getUserById(id);
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());

        return userDto;
    }
}
