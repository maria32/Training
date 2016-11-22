package com.endava.springmvc.controller;

import com.endava.springmvc.dtos.UserDto;
import com.endava.springmvc.model.User;
import com.endava.springmvc.service.UserService;
import com.endava.springmvc.service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martanase on 11/18/2016.
 */

@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserViewService userViewService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUser(@PathVariable(name = "id") Integer id){
        return userViewService.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        System.out.println("\t****create");
        return userService.create(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        return userService.updateUser(user);
    }

}
