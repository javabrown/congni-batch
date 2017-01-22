package javabrown.cognitest.data;

public class InputTransactionData {
    private String _policyId;
    private String _policyHolderId;
    private String _dateOfService;
    private String _coverageMainCategory;
    private String _coverageSubCategory;
    private String _billedAmount;

    public String getPolicyId() {
        return _policyId;
    }

    public void setPolicyId(String policyId) { _policyId = policyId; }

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

    @Override
    public String toString() {
        return "InputTransactionData{" +
                "policyId='" + _policyId + '\'' +
                ", policyHolderId='" + _policyHolderId + '\'' +
                ", dateOfService='" + _dateOfService + '\'' +
                ", coverageMainCategory='" + _coverageMainCategory + '\'' +
                ", coverageSubCategory='" + _coverageSubCategory + '\'' +
                ", billedAmount='" + _billedAmount + '\'' +
                '}';
    }
}
