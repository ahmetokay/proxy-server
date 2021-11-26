package com.okay.controller;

import com.okay.model.BaseResponseDto;
import com.okay.model.UserDto;
import com.okay.model.UserRequestDto;
import com.okay.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseDto> test1(@Valid @RequestBody UserRequestDto userRequestDto) {
        List<UserDto> userList = userService.filter(userRequestDto.getName(), userRequestDto.getSurname());
        return new ResponseEntity<>(BaseResponseDto.builder().code(200).message("success").data(userList).build(), HttpStatus.OK);
    }
}