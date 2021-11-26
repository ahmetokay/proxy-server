package com.okay.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponseDto {

    private int code;

    private String message;

    private HeaderDto header;

    private Object data;
}