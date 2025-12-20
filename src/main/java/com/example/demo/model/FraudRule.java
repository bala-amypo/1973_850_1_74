package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fraud_rules") // Required table name
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key
    private Long id;

    @Column(unique = true, nullable = false) // ruleName must be unique
    private String ruleName;

    private String conditionField; // Field to inspect

    private String operator; // Comparison operator

    private String value; // Threshold value

    private String severity; // LOW, MEDIUM, or HIGH

    // Many-to-many with Claim; Claim holds 'suspectedRules'
    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims = new HashSet<>();

    // No-arg constructor
    public FraudRule() {
    }

    // Parameterized constructor
    public FraudRule(String ruleName, String conditionField, String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getConditionField() {
        return conditionField;
    }

    public void setConditionField(String conditionField) {
        this.conditionField = conditionField;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Set<Claim> getClaims() {
        return claims;
    }

    public void setClaims(Set<Claim> claims) {
        this.claims = claims;
    }
}