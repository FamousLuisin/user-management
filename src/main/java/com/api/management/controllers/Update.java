package com.api.management.controllers;

import com.api.management.model.dto.UserUpdateDTO;
import com.api.management.model.entities.User;
import com.api.management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/update")
public class Update {

    @Autowired
    private UserService userService;

    @GetMapping
    public String updateMenu(){
        return "Update menu";
    }

    @PostMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody UserUpdateDTO user){
        User userUpdate = userService.updateUser(user);
        return ResponseEntity.ok(userUpdate);
    }
}
