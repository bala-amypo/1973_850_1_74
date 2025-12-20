package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;
    
    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt;

    @PrePersist
    protected void onCreate() {
        this.checkedAt = LocalDateTime.now();
    }

    public FraudCheckResult() {}
}