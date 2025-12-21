package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_check_results")
public class FraudCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 108]

    @OneToOne
    @JoinColumn(name = "claim_id")
    private Claim claim; // 

    private Boolean isFraudulent; // [cite: 110]
    private String triggeredRuleName; // [cite: 111]
    private String rejectionReason; // [cite: 112]
    private LocalDateTime checkedAt; // [cite: 113]

    // No-arg constructor [cite: 115]
    public FraudCheckResult() {}

    // Parameterized constructor [cite: 116]
    public FraudCheckResult(Claim claim, Boolean isFraudulent, String triggeredRuleName, 
                            String rejectionReason, LocalDateTime checkedAt) {
        this.claim = claim;
        this.isFraudulent = isFraudulent;
        this.triggeredRuleName = triggeredRuleName;
        this.rejectionReason = rejectionReason;
        this.checkedAt = checkedAt;
    }

    // Automatically set checkedAt before saving to database 
    @PrePersist
    protected void onCreate() {
        this.checkedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Claim getClaim() { return claim; }
    public void setClaim(Claim claim) { this.claim = claim; }
    public Boolean getIsFraudulent() { return isFraudulent; }
    public void setIsFraudulent(Boolean fraudulent) { isFraudulent = fraudulent; }
    public String getTriggeredRuleName() { return triggeredRuleName; }
    public void setTriggeredRuleName(String triggeredRuleName) { this.triggeredRuleName = triggeredRuleName; }
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
}