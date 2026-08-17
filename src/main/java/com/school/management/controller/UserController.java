package com.school.management.controller;
import org.springframework.stereotype.Controller;

import com.school.management.entity.User;
import com.school.management.entity.UserRole;
import com.school.management.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String showCreateUserForm() {
        return "users/create";
    }

    @PostMapping
    public String createUser(
        @RequestParam String username,
        @RequestParam String password,
        @RequestParam UserRole role) {

        System.out.println("CREATE USER: " + username + " / " + role);

    userService.createUser(username, password, role);

    return "redirect:/users/new";
}

@GetMapping
public String listUsers(Model model) {

    List<User> users = userService.getAllUsers();

    model.addAttribute("users", users);

    return "users/list";
}

   

   

}