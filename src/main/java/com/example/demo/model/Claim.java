package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite: 66, 454]

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy; [cite: 67, 454]

    private LocalDate claimDate; [cite: 68, 454]
    private Double claimAmount; [cite: 69, 454]
    private String description; [cite: 70, 454]
    private String status; // PENDING, APPROVED, or REJECTED [cite: 71, 454]

    @ManyToMany
    @JoinTable(
        name = "claim_fraud_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<FraudRule> suspectedRules; [cite: 77, 98]

    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private FraudCheckResult fraudCheckResult; [cite: 78, 109]

    // No-arg constructor
    public Claim() {} [cite: 73]

    // Parameterized constructor - Signature required by test cases
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
    } [cite: 74]

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Policy getPolicy() { return policy; }
    public void setPolicy(Policy policy) { this.policy = policy; }
    public LocalDate getClaimDate() { return claimDate; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
    public Double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Set<FraudRule> getSuspectedRules() { return suspectedRules; }
    public void setSuspectedRules(Set<FraudRule> suspectedRules) { this.suspectedRules = suspectedRules; }
    public FraudCheckResult getFraudCheckResult() { return fraudCheckResult; }
    public void setFraudCheckResult(FraudCheckResult fraudCheckResult) { this.fraudCheckResult = fraudCheckResult; }
}