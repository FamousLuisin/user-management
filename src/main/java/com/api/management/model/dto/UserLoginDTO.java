package com.api.management.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {

    @NotBlank(message = "email is mandatory")
    @Size(min = 5, max = 125)
    @Email
    public String email;

    @NotBlank(message = "password is mandatory")
    public String password;
}
