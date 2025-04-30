package com.example.Document.Collaboration.repositories;

import com.example.Document.Collaboration.DTO.LoginRequest;
import com.example.Document.Collaboration.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
