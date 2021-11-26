package com.okay.controller;

import com.okay.model.BaseRequestDto;
import com.okay.model.BaseResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseDto> test1(@RequestBody BaseRequestDto baseRequestDto) {
        return new ResponseEntity<>(BaseResponseDto.builder().code(200).message("success").data("token=" + baseRequestDto.getToken()).build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseDto> test2(@RequestBody BaseRequestDto baseRequestDto) {
        return new ResponseEntity<>(BaseResponseDto.builder().code(200).message("success").data("token=" + baseRequestDto.getToken()).build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
//    @GetMapping(value = "/test3")
    public ResponseEntity<String> test3(@RequestBody Object requestDto) {
        return new ResponseEntity<>("token=test", HttpStatus.OK);
    }
}