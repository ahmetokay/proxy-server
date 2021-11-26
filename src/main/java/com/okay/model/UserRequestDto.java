package com.okay.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRequestDto extends BaseRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;
}