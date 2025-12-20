package com.example.demo.repository;

import com.example.demo.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // This fixes the "cannot find symbol existsByPolicyNumber" error
    boolean existsByPolicyNumber(String policyNumber);
}