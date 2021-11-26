package com.okay.service;

import com.okay.model.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> filter(String name, String surname);
}