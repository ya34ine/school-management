package com.school.management.controller;

import com.school.management.entity.User;
import com.school.management.entity.UserRole;
import com.school.management.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam UserRole role) {

        return userService.createUser(username, password, role);
    }
}