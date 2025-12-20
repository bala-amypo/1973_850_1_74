package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User registerUser(User user); // [cite: 399]
    User findByEmail(String email); // [cite: 400]
    User findById(Long id); // [cite: 401]
}