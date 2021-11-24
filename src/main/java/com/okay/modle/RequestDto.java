package com.okay.modle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDto {

    private String application;

    private String channel;

    private String tid;

    private String token;
}