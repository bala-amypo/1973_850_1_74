package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_check_results") // Required table name
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key
    private Long id;

    // One-to-one with Claim: The claim that was evaluated
    @OneToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    private Boolean isFraudulent; // Whether claim is considered fraudulent

    private String triggeredRuleName; // Name of main rule that caused the flag

    private String rejectionReason; // Human-readable explanation

    private LocalDateTime checkedAt; // Timestamp of evaluation

    // No-arg constructor
    public FraudCheckResult() {
    }

    // Parameterized constructor
    public FraudCheckResult(Claim claim, Boolean isFraudulent, String triggeredRuleName, 
                            String rejectionReason, LocalDateTime checkedAt) {
        this.claim = claim;
        this.isFraudulent = isFraudulent;
        this.triggeredRuleName = triggeredRuleName;
        this.rejectionReason = rejectionReason;
        this.checkedAt = checkedAt;
    }

    // Entity Lifecycle Rule: checkedAt must be set automatically
    @PrePersist
    protected void onCreate() {
        if (this.checkedAt == null) {
            this.checkedAt = LocalDateTime.now();
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Boolean getIsFraudulent() {
        return isFraudulent;
    }

    public void setIsFraudulent(Boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }

    public String getTriggeredRuleName() {
        return triggeredRuleName;
    }

    public void setTriggeredRuleName(String triggeredRuleName) {
        this.triggeredRuleName = triggeredRuleName;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}