package com.api.management.controllers;

import com.api.management.model.dto.UserRegisterDTO;
import com.api.management.model.entities.User;
import com.api.management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
public class Register {

    @Autowired
    private UserService userService;

    @GetMapping
    public String registerMenu(){
        return "Register menu";
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO){
        User user = userService.createUser(userRegisterDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
