package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "claims") // Required table name
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key
    private Long id;

    // Many-to-one with Policy: Policy under which claim is filed
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    private LocalDate claimDate; // Date of claim

    private Double claimAmount; // Amount requested

    private String description; // Description of incident

    private String status; // PENDING, APPROVED, or REJECTED

    // Many-to-many with FraudRule using sets on both sides
    @ManyToMany
    @JoinTable(
        name = "claim_fraud_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "fraud_rule_id")
    )
    private Set<FraudRule> suspectedRules = new HashSet<>();

    // One-to-one with FraudCheckResult
    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private FraudCheckResult fraudCheckResult;

    // No-arg constructor
    public Claim() {
    }

    // Parameterized constructor
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
        this.status = "PENDING"; // Common practice to default to PENDING
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<FraudRule> getSuspectedRules() {
        return suspectedRules;
    }

    public void setSuspectedRules(Set<FraudRule> suspectedRules) {
        this.suspectedRules = suspectedRules;
    }

    public FraudCheckResult getFraudCheckResult() {
        return fraudCheckResult;
    }

    public void setFraudCheckResult(FraudCheckResult fraudCheckResult) {
        this.fraudCheckResult = fraudCheckResult;
    }
}