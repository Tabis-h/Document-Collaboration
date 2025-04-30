package com.example.Document.Collaboration.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)

    private String name;

    @Column(nullable = false,unique = true)

    private String email;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
