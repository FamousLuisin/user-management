package com.api.management.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 60)
    private String name;

    @NotBlank(message = "email is mandatory")
    @Size(min = 5, max = 125)
    private String email;
}
