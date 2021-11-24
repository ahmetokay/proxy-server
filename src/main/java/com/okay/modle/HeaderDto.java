package com.okay.modle;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class HeaderDto implements Serializable {

    private String application;

    private String channel;

    private String tid;
}