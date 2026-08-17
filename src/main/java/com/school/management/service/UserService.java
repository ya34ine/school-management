package com.school.management.service;

import com.school.management.entity.User;
import com.school.management.entity.UserRole;
import com.school.management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public List<User> getAllUsers() {
    return userRepository.findAll();
}

    public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("User not found: " + id)
            );
}

    public User updateUser(
        Long id,
        String username,
        UserRole role) {

    User user = userRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("User not found: " + id)
            );

    user.setUsername(username);
    user.setRole(role);

    return userRepository.save(user);
}




}