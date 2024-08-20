package com.api.management.controllers;

import com.api.management.model.entities.User;
import com.api.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/read")
public class Read {

    @Autowired
    private UserService userService;

    @GetMapping
    public String readMenu(){
        return "Read menu";
    }

    @GetMapping(path = "/users")
    public Iterable<User> userList(){
        return userService.readAllUsers();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<?> userById(@PathVariable int id){
        try {
            User user = userService.readUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping(path = "/name/{name}")
    public Iterable<User> userByName(@PathVariable String name){
        return userService.readUserByName(name);
    }


}
