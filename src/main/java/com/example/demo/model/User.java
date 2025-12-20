package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Required table name [cite: 25]
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Required primary key [cite: 27]
    private Long id;

    private String name;

    @Column(unique = true) // Email must be unique [cite: 29]
    private String email;

    private String password; // Stored as hashed value [cite: 30]
    private String role; // "USER" or "ADMIN" [cite: 31]

    public User() {} // Required no-arg constructor [cite: 33]

    public User(String name, String email, String password, String role) { // [cite: 34]
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters [cite: 219]
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}