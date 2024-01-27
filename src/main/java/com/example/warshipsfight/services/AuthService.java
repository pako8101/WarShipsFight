package com.example.warshipsfight.services;


import com.example.warshipsfight.models.User;
import com.example.warshipsfight.models.dtos.LoginDTO;
import com.example.warshipsfight.models.dtos.UserRegistrationDTO;
import com.example.warshipsfight.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    final private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()){
            return false;
        }
        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getEmail());
        if (byUsername.isPresent()){
            return false;
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setFullName(registrationDTO.getFullName());
        user.setPassword(registrationDTO.getPassword());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(LoginDTO loginDTO) {

    }
}
