package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 88]

    @Column(unique = true)
    private String ruleName; // [cite: 89]

    private String conditionField; // [cite: 90]
    private String operator; // [cite: 91]
    private String value; // [cite: 92]
    private String severity; // [cite: 93]

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims; // [cite: 98]

    // No-arg constructor
    public FraudRule() {} // [cite: 95]

    // Parameterized constructor - MUST match this signature exactly
    public FraudRule(String ruleName, String conditionField, String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    } // [cite: 96]

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getConditionField() { return conditionField; }
    public void setConditionField(String conditionField) { this.conditionField = conditionField; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public Set<Claim> getClaims() { return claims; }
    public void setClaims(Set<Claim> claims) { this.claims = claims; }
}