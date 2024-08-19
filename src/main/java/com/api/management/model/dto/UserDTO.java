package com.api.management.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 60)
    public String name;

    @NotBlank(message = "email is mandatory")
    @Size(min = 5, max = 125)
    @Email
    public String email;

    @NotBlank(message = "password is mandatory")
    public String password;

    @NotNull
    public LocalDate birth;
}
