package com.api.management.controllers;

import com.api.management.model.dto.UserLoginDTO;
import com.api.management.model.entities.User;
import com.api.management.repository.UserRepository;
import com.api.management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/delete")
public class Delete {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public String deleteMenu(){
        return "Delete menu";
    }

    @PostMapping(path = "/{id}")
    public Optional<User> deleteUser(@PathVariable int id){
        Optional<User> deleteUser = userRepository.findById(id);
        userRepository.deleteById(id);

        return deleteUser;
    }

    @PostMapping
    public ResponseEntity<?> deleteUserByLogin(@Valid @RequestBody UserLoginDTO userLoginDTO){
        try {
            User user = userService.loginUser(userLoginDTO);
            userRepository.delete(user);

            return ResponseEntity.ok(user);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
