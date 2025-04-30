package com.example.Document.Collaboration.controllers;

import com.example.Document.Collaboration.DTO.LoginRequest;
import com.example.Document.Collaboration.models.User;
import com.example.Document.Collaboration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping("/{username}")

    public ResponseEntity<User> verifyUser(@PathVariable String username){

        return userService.verifyUsername(username).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")

    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        boolean isAuthenticated = userService.authenticateUser(loginRequest.getUsername(),loginRequest.getPassword());

        if(isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
