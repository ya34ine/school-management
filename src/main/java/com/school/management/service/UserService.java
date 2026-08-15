package com.school.management.service;

import com.school.management.entity.User;
import com.school.management.entity.UserRole;
import com.school.management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(
            String username,
            String password,
            UserRole role) {

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(
                username,
                encodedPassword,
                role
        );

        return userRepository.save(user);
    }
}