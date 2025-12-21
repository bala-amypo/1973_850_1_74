package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Add this line to fix the "cannot find symbol: findByUsername" error
    Optional<User> findByUsername(String username);
}