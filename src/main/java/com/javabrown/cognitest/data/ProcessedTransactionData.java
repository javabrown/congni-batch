package com.javabrown.cognitest.data;

public class ProcessedTransactionData {
    private String _policyId;
    private String _policyHolderId;
    private String _dateOfService;
    private String _coverageMainCategory;
    private String _coverageSubCategory;
    private String _billedAmount;
    private String _policyHolderPays;
    private String _planPays;
    private String _ruleUsed;
    private String _individualAccumulatedDeductible;
    private String _familyAccumulatedDeductible;

    public String getPolicyId() {
        return _policyId;
    }

    public void setPolicyId(String policyId) {
        _policyId = policyId;
    }

    public String getPolicyHolderId() {
        return _policyHolderId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        _policyHolderId = policyHolderId;
    }

    public String getDateOfService() {
        return _dateOfService;
    }

    public void setDateOfService(String dateOfService) {
        _dateOfService = dateOfService;
    }

    public String getCoverageMainCategory() {
        return _coverageMainCategory;
    }

    public void setCoverageMainCategory(String coverageMainCategory) {
        _coverageMainCategory = coverageMainCategory;
    }

    public String getCoverageSubCategory() {
        return _coverageSubCategory;
    }

    public void setCoverageSubCategory(String coverageSubCategory) {
        _coverageSubCategory = coverageSubCategory;
    }

    public String getBilledAmount() {
        return _billedAmount;
    }

    public void setBilledAmount(String billedAmount) {
        _billedAmount = billedAmount;
    }

    public String getPolicyHolderPays() {
        return _policyHolderPays;
    }

    public void setPolicyHolderPays(String policyHolderPays) {
        _policyHolderPays = policyHolderPays;
    }

    public String getPlanPays() {
        return _planPays;
    }

    public void setPlanPays(String planPays) {
        _planPays = planPays;
    }

    public String getRuleUsed() {
        return _ruleUsed;
    }

    public void setRuleUsed(String ruleUsed) {
        _ruleUsed = ruleUsed;
    }

    public String getIndividualAccumulatedDeductible() {
        return _individualAccumulatedDeductible;
    }

    public void setIndividualAccumulatedDeductible(String individualAccumulatedDeductible) {
        _individualAccumulatedDeductible = individualAccumulatedDeductible;
    }

    public String getFamilyAccumulatedDeductible() {
        return _familyAccumulatedDeductible;
    }

    public void setFamilyAccumulatedDeductible(String familyAccumulatedDeductible) {
        _familyAccumulatedDeductible = familyAccumulatedDeductible;
    }
}
