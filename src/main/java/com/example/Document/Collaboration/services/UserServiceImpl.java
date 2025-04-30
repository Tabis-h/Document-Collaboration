package com.example.Document.Collaboration.services;

import com.example.Document.Collaboration.configuration.PasswordConfig;
import com.example.Document.Collaboration.models.User;
import com.example.Document.Collaboration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncode;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncode) {
        this.userRepository = userRepository;


        this.passwordEncode = passwordEncode;
    }

    @Override
    public User saveUser(User user) {

        String encodedPassword = passwordEncode.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);

    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> verifyUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
           return passwordEncode.matches(password, user.getPassword());
        }
        return false;
    }
}
