package com.example.demo.repository;

import com.example.demo.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    
    // Checks if policy number exists (used in createPolicy)
    boolean existsByPolicyNumber(String policyNumber);

    // FIX: Finds all policies belonging to a specific user
    List<Policy> findByUserId(Long userId);
}