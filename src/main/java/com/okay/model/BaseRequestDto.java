package com.okay.model;

import lombok.Data;

@Data
public class BaseRequestDto {

    private String application;

    private String channel;

    private String tid;

    private String token;
}