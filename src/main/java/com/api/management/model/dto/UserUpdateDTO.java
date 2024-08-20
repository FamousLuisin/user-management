package com.api.management.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserUpdateDTO {

    @NotNull
    public Integer id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 60)
    public String name;

    @NotBlank
    @Size(min = 5, max = 125)
    @Email
    public String email;

    @NotBlank
    @NotNull
    public String password;

    @NotNull
    public LocalDate birth;
}
