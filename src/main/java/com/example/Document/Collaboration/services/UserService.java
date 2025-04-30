package com.example.Document.Collaboration.services;

import com.example.Document.Collaboration.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> getUser();

    Optional<User> verifyUsername(String username);

    boolean authenticateUser(String username, String password);

}
