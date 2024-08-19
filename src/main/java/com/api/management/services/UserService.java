package com.api.management.services;

import com.api.management.model.dto.UserLoginDTO;
import com.api.management.model.dto.UserRegisterDTO;
import com.api.management.model.entities.User;
import com.api.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRegisterDTO userRegisterDTO){

        boolean emailIsPresent = userRepository.existsByEmail(userRegisterDTO.email);

        if (!emailIsPresent){
            User user = new User();

            user.setName(userRegisterDTO.name);
            user.setBirth(userRegisterDTO.birth);
            user.setEmail(userRegisterDTO.email);
            user.setPassword(userRegisterDTO.password);

            return userRepository.save(user);
        }

        return null;
    }

    public User loginUser(UserLoginDTO userLoginDTO){

        Optional<User> optionalUser = userRepository.findByEmail(userLoginDTO.email);

        if (optionalUser.isPresent()){
            User userLogin = optionalUser.get();

            if (userLogin.getPassword().equals(userLoginDTO.password)){
                return userLogin;
            }

            else{
                throw  new RuntimeException("Senha incorreta");
            }
        }

        throw new RuntimeException("Email não encontrado");
    }
}
