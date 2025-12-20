package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    // Constructor injection for all security components
    public AuthController(UserService userService, 
                          AuthenticationManager authenticationManager, 
                          JwtUtil jwtUtil, 
                          UserDetailsService userDetailsService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AuthRequest request) {
        User user = new User(request.getName(), request.getEmail(), request.getPassword(), "USER");
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // 1. Authenticate the user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2. Load user details
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        User user = userService.findByEmail(request.getEmail());

        // 3. Generate the token
        final String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());

        // 4. Return the DTO response
        return ResponseEntity.ok(new AuthResponse(token, user.getEmail(), user.getRole()));
    }
}