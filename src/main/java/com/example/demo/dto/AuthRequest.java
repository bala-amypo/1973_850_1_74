package com.example.demo.dto;

public class AuthRequest {
    private String name; // Used for registration only [cite: 302]
    private String email; // Login email [cite: 303]
    private String password; // Raw password [cite: 304]

    // Default Constructor
    public AuthRequest() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}