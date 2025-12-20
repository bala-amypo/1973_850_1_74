package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String ruleExpression;
    private String description;
    private boolean active;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getRuleExpression() { return ruleExpression; }
    public void setRuleExpression(String ruleExpression) { this.ruleExpression = ruleExpression; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}