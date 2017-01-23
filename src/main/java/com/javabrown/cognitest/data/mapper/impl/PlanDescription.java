package com.javabrown.cognitest.data.mapper.impl;

public class PlanDescription {
    private String _planId;
    private String _planName;
    private String _coverageType;
    private String _estimatedPremium;
    private String _annualDeductableIndividual;
    private String _annualDeductableFamily;

    public String getPlanId() {
        return _planId;
    }

    public String getPlanName() {
        return _planName;
    }

    public String getCoverageType() {
        return _coverageType;
    }


    public String getEstimatedPremium() {
        return _estimatedPremium;
    }

    public String getAnnualDeductableIndividual() {
        return _annualDeductableIndividual;
    }

    public String getAnnualDeductableFamily() {
        return _annualDeductableFamily;
    }

    public void setPlanId(String planId) {
        _planId = planId;
    }

    public void setPlanName(String planName) {
        _planName = planName;
    }

    public void setCoverageType(String coverageType) {
        _coverageType = coverageType;
    }


    public void setEstimatedPremium(String estimatedPremium) {
        _estimatedPremium = estimatedPremium;
    }

    public void setAnnualDeductableIndividual(String annualDeductableIndividual) {
        _annualDeductableIndividual = annualDeductableIndividual;
    }

    public void setAnnualDeductableFamily(String annualDeductableFamily) {
        _annualDeductableFamily = annualDeductableFamily;
    }

    @Override
    public String toString() {
        return "PlanDescription{" +
                "_planId='" + _planId + '\'' +
                ", _planName='" + _planName + '\'' +
                ", _coverageType='" + _coverageType + '\'' +
                ", _estimatedPremium='" + _estimatedPremium + '\'' +
                ", _annualDeductableIndividual='" + _annualDeductableIndividual + '\'' +
                ", _annualDeductableFamily='" + _annualDeductableFamily + '\'' +
                '}';
    }
}
