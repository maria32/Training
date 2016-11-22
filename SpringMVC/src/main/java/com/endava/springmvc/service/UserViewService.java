package com.endava.springmvc.service;

import com.endava.springmvc.dtos.UserDto;

/**
 * Created by martanase on 11/22/2016.
 */
public interface UserViewService {

    UserDto findById(Integer id);

}
