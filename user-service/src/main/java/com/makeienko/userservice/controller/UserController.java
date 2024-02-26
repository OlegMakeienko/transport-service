package com.makeienko.userservice.controller;

import com.makeienko.userservice.model.User;
import com.makeienko.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/show-users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.getAllUsers();
        if(users != null && !users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else return ResponseEntity.noContent().build();
    }
}

