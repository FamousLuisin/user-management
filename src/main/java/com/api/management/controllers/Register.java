package com.api.management.controllers;

import com.api.management.model.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
public class Register {

    @GetMapping
    public String registerMenu(){
        return "Register menu";
    }

    @PostMapping
    public void registerUser(@Valid @RequestBody UserDTO userDTO){

    }

}
