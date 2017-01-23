package com.javabrown.cognitest.data.mapper;

import com.javabrown.cognitest.data.mapper.impl.PlanDescription;
import com.javabrown.cognitest.data.mapper.impl.SubCategory;

public interface PlanCoverageI {
    String getPlanRuleApplied(String planId, String mainCategory, String subCategory);

    PlanDescription getPlanDescription(String planId, String mainCategory, String subCategory);

    String getPlanPaymentRule(String planId, String mainCategory, String subCategory);

    void createNewMainCaregory(String mainCategoryName);

    void addSubCategoryUnderMainCaregory(String mainCategoryName, SubCategory subCategory);
}