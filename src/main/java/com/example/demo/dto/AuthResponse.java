package com.example.demo.dto;

public class AuthResponse {
    private String token; // JWT token [cite: 308]
    private Long userId; // Logged-in user id [cite: 309]
    private String email; // User email [cite: 310]
    private String role; // User role (USER or ADMIN) [cite: 311]

    public AuthResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}