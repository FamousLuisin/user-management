package com.api.management.controllers;

import com.api.management.model.entities.User;
import com.api.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/read")
public class Read {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String readMenu(){
        return "Read menu";
    }

    @GetMapping(path = "/users")
    public Iterable<User> userList(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/id/{id}")
    public Optional<User> userById(@PathVariable int id){
        return userRepository.findById(id);
    }

    @GetMapping(path = "/name/{name}")
    public Iterable<User> userByName(@PathVariable String name){
        return userRepository.findByNameContaining(name);
    }


}
