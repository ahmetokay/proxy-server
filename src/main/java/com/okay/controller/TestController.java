package com.okay.controller;

import com.okay.modle.RequestDto;
import com.okay.modle.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> test1(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(ResponseDto.builder().code(200).message("success").data("token=" + requestDto.getToken()).build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> test2(@RequestBody RequestDto requestDto) {
        return new ResponseEntity<>(ResponseDto.builder().code(200).message("success").data("token=" + requestDto.getToken()).build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/test3", method = RequestMethod.POST)
    public ResponseEntity<String> test3(@RequestBody Object requestDto) {
        return new ResponseEntity<>("token=test", HttpStatus.OK);
    }
}