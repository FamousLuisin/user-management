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
@RequestMapping(path = "/delete")
public class Delete {

    @Autowired
    private UserService userService;

    @GetMapping
    public String deleteMenu(){
        return "Delete menu";
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        try {
            User user = userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> deleteUserByLogin(@Valid @RequestBody UserLoginDTO userLoginDTO){
        try {
            User user = userService.deleteUserByLogin(userLoginDTO);

            return ResponseEntity.ok(user);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
