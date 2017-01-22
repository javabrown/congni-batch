package javabrown.cognitest.data.mapper;

public class PolicyData {
    private String _policyId;
    private String _policyHolderId;
    private String _firstName;
    private String _lastName;
    private String _planId;
    private String _coverageStartDate;
    private String _coverageEndDate;
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

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getPlanId() {
        return _planId;
    }

    public void setPlanId(String planId) {
        _planId = planId;
    }

    public String getCoverageStartDate() {
        return _coverageStartDate;
    }

    public void setCoverageStartDate(String coverageStartDate) {
        _coverageStartDate = coverageStartDate;
    }

    public String getCoverageEndDate() {
        return _coverageEndDate;
    }

    public void setCoverageEndDate(String coverageEndDate) {
        _coverageEndDate = coverageEndDate;
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

    @Override
    public String toString() {
        return "PolicyData{" +
                "_policyId='" + _policyId + '\'' +
                ", _policyHolderId='" + _policyHolderId + '\'' +
                ", _firstName='" + _firstName + '\'' +
                ", _lastName='" + _lastName + '\'' +
                ", _planId='" + _planId + '\'' +
                ", _coverageStartDate='" + _coverageStartDate + '\'' +
                ", _coverageEndDate='" + _coverageEndDate + '\'' +
                ", _individualAccumulatedDeductible='" + _individualAccumulatedDeductible + '\'' +
                ", _familyAccumulatedDeductible='" + _familyAccumulatedDeductible + '\'' +
                '}';
    }
}
