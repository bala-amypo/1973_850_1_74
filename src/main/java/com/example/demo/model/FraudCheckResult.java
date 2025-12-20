package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_check_results") // [cite: 106]
public class FraudCheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // One-to-one with Claim [cite: 109]
    @JoinColumn(name = "claim_id")
    private Claim claim;

    private Boolean isFraudulent;
    private String triggeredRuleName;
    private String rejectionReason;
    private LocalDateTime checkedAt; // Must be set automatically [cite: 119]

    @PrePersist // Auto-sets the timestamp before saving to DB [cite: 119]
    protected void onCreate() {
        this.checkedAt = LocalDateTime.now();
    }

    public FraudCheckResult() {} // [cite: 115]

    public FraudCheckResult(Claim claim, Boolean isFraudulent, String triggeredRuleName, String rejectionReason, LocalDateTime checkedAt) { // [cite: 116]
        this.claim = claim;
        this.isFraudulent = isFraudulent;
        this.triggeredRuleName = triggeredRuleName;
        this.rejectionReason = rejectionReason;
        this.checkedAt = checkedAt;
    }

    // Getters and Setters [cite: 219]
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Claim getClaim() { return claim; }
    public void setClaim(Claim claim) { this.claim = claim; }
    public Boolean getIsFraudulent() { return isFraudulent; }
    public void setIsFraudulent(Boolean isFraudulent) { this.isFraudulent = isFraudulent; }
    public String getTriggeredRuleName() { return triggeredRuleName; }
    public void setTriggeredRuleName(String triggeredRuleName) { this.triggeredRuleName = triggeredRuleName; }
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
}