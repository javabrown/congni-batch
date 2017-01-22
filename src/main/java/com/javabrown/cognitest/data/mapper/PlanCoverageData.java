package com.javabrown.cognitest.data.mapper;

import com.javabrown.cognitest.utils.Utils;

public class PlanCoverageData {
    private String mainCategory;
    private String subCategory;
    private String planId_p001;
    private String planId_p002;
    private String planId_p003;

    public String getMainCategory() {
        return this.mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getPlanId_p001() {
        return planId_p001;
    }

    public void setPlanId_p001(String planId_p001) {
        this.planId_p001 = planId_p001;
    }

    public String getPlanId_p002() {
        return planId_p002;
    }

    public void setPlanId_p002(String planId_p002) {
        this.planId_p002 = planId_p002;
    }

    public String getPlanId_p003() {
        return planId_p003;
    }

    public void setPlanId_p003(String planId_p003) {
        this.planId_p003 = planId_p003;
    }

    public boolean isEmpty(String... str) {
        return Utils.isEmpty(this.mainCategory) && Utils.isEmpty(this.subCategory,
                this.planId_p001, this.planId_p002, this.planId_p003);
    }

    public boolean isMainCategory() {
        return !Utils.isEmpty(this.mainCategory);
    }

    public SubCategory makeSubCategory() {
        return new SubCategory(this.subCategory, this.planId_p001, this.planId_p002, this.planId_p003);
    }
}
