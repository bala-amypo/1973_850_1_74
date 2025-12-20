package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Required table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key, auto-generated
    private Long id;

    private String name; // Full name

    @Column(unique = true) // Email must be unique
    private String email;

    private String password; // Hashed password

    private String role; // "USER" or "ADMIN"

    // One-to-many with Policy: a user can own many policies
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Policy> policies = new ArrayList<>();

    // No-arg constructor
    public User() {
    }

    // Parameterized constructor that just assigns fields
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
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

    public List<Policy> getPolicies() { return policies; }
    public void setPolicies(List<Policy> policies) { this.policies = policies; }
}