package com.okay.modle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private int code;

    private String message;

    private HeaderDto header;

    private Object data;
}