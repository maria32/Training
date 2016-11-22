package com.endava.springmvc.dtos;

import java.io.Serializable;

/**
 * Created by martanase on 11/22/2016.
 */
public class UserDto implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
