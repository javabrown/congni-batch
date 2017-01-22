package javabrown.cognitest.data.mapper;

import java.util.ArrayList;

public interface PlanCoverageI {
    String getPlanRuleApplied(String planId, String mainCategory, String subCategory);

    PlanDescription getPlanDescription(String planId, String mainCategory, String subCategory);

    void createNewMainCaregory(String mainCategoryName);

    void addSubCategoryUnderMainCaregory(String mainCategoryName, SubCategory subCategory);
}