package com.api.management.controllers;

import com.api.management.model.dto.UserLoginDTO;
import com.api.management.model.entities.User;
import com.api.management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "login")
public class Login {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginMenu(){
        return "Login menu";
    }

    @PostMapping
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO){
        try{
            User user = userService.loginUser(userLoginDTO);

            return ResponseEntity.ok(user);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
