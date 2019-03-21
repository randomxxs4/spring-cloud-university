package ru.university.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.university.authenticationservice.entity.User;
import ru.university.authenticationservice.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
