package com.example.demo.repository;

import com.example.demo.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    Optional<Policy> findByPolicyNumber(String policyNumber); // [cite: 179]
    boolean existsByPolicyNumber(String policyNumber); // [cite: 180]
    List<Policy> findByUserId(Long userId); // [cite: 181]
}