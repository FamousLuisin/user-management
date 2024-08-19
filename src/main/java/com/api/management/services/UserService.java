package com.api.management.services;

import com.api.management.model.dto.UserDTO;
import com.api.management.model.entities.User;
import com.api.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO){

        boolean emailIsPresent = userRepository.existsByEmail(userDTO.email);

        if (!emailIsPresent){
            User user = new User();

            user.setName(userDTO.name);
            user.setBirth(userDTO.birth);
            user.setEmail(userDTO.email);
            user.setPassword(userDTO.password);

            return userRepository.save(user);
        }

        return null;
    }
}
