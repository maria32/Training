package com.endava.springmvc.service;

import com.endava.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by martanase on 11/18/2016.
 */

@Service
public class UserServiceImpl implements UserService{


    private static List<User> users;

    static{
        users = new ArrayList<User>();
        users.add(new User(1, "Maria", 34));
        users.add(new User(2, "Lorena", 20));
        users.add(new User(3, "Mirel", 24));
        users.add(new User(4, "Marcel", 44));
        users.add(new User(5, "Valeria", 22));
    }
    public User getUserById(Integer id){
        for(User user: users){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public void deleteUserById(Integer id) {
        Iterator<User> iterator = users.iterator();
        User usr;
        while(iterator.hasNext()) {
            usr = iterator.next();
            if(usr.getId() == id) {
                iterator.remove();
            }
        }
    }

    public User updateUser(User user){
        for(User userInUsers: users){
            if(userInUsers.getId() == user.getId()) {
                userInUsers.setName(user.getName());
                userInUsers.setAge(user.getAge());
            }
        }
        return null;
    }

    public User create(User user){
        System.out.println("I'm in create");
        System.out.println("user.getId() = " + user.getId());
        User existingUser = user.getId() == null ? null : getUserById(user.getId());
        if(existingUser != null)
            return null;
        users.add(user);
        return user;
    }

}
