package com.example.demo.service;

import com.example.demo.model.Policy;
import java.util.List;

public interface PolicyService {
    Policy createPolicy(Long userId, Policy policy); // [cite: 411]
    List<Policy> getPoliciesByUser(Long userId); // [cite: 412]
    Policy getPolicy(Long id); // [cite: 413]
}