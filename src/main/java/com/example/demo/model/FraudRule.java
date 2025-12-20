package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleName;
    private String ruleExpression;
    private String description;
    private String conditionField;
    private String operator;
    private String value;
    private String severity;
    private boolean active;

    @ManyToMany(mappedBy = "suspectedRules")
    private Set<Claim> claims;

    public FraudRule() {}
    public FraudRule(String ruleName, String conditionField, String operator, String value, String severity) {
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // Setters to fix Errors
    public void setRuleExpression(String ruleExpression) { this.ruleExpression = ruleExpression; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(boolean active) { this.active = active; }
    public String getSeverity() { return severity; }
}