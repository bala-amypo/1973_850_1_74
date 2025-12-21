package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Fixes "cannot find symbol: findByUsername"
    Optional<User> findByUsername(String username);

    // Fixes "cannot find symbol: findByEmail"
    Optional<User> findByEmail(String email);

    // Fixes "cannot find symbol: existsByEmail"
    boolean existsByEmail(String email);
}


kill -9 $(lsof -t -i:9001)