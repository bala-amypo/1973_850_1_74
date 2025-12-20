package com.example.demo.dto;

public class FraudRuleDto {
    private String ruleName;
    private String ruleExpression;
    private String description;

    // Getters and Setters
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getRuleExpression() { return ruleExpression; }
    public void setRuleExpression(String ruleExpression) { this.ruleExpression = ruleExpression; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}