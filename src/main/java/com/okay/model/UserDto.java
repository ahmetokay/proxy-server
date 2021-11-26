package com.okay.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private String name;

    private String surname;

    private String gender;
}