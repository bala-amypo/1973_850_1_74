package com.example.demo.repository;

import com.example.demo.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // This uses the 'id' field which ALREADY exists in your Policy model
    Optional<Policy> findById(Long id);
    
    // This allows you to get all policies for a specific user
    List<Policy> findByUserId(Long userId);
}