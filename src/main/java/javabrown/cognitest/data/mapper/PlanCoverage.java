package javabrown.cognitest.data.mapper;

import javabrown.cognitest.utils.PlanDataCache;

import java.util.*;
import java.util.stream.Stream;
import static javabrown.cognitest.utils.KeysI.*;

public class PlanCoverage implements PlanCoverageI {

    private final Map<String, List<SubCategory>> _coverageMap;
    private final Map<PlanKey, PlanDetails> _planMap;

    public PlanCoverage() {
        _coverageMap = new HashMap<String, List<SubCategory>>();
        _planMap = new HashMap<PlanKey, PlanDetails>();
    }


    public void createNewMainCaregory(String mainCategoryName) {
        _coverageMap.put(mainCategoryName, new ArrayList<SubCategory>());
    }

    public void addSubCategoryUnderMainCaregory(String mainCategoryName, SubCategory subCategory) {

        _coverageMap.get(mainCategoryName).add(subCategory);

        Stream.of(P001, P002, P003).forEach((k) -> {
            PlanKey planKey = new PlanKey(k, mainCategoryName, subCategory.getName());
            PlanDetails detail = new PlanDetails(k, subCategory.getName(),
                    PlanDataCache.getInstance().getPlanDescriptionMap().get(k));
            _planMap.put(planKey, detail);
        });


    }

    public Map<String, List<SubCategory>> getCoverageMap() {
        return _coverageMap;
    }

    @Override
    public String getPlanRuleApplied(String planId, String mainCategory, String subCategory){
        PlanDetails detail = _planMap.get(new PlanKey(planId, mainCategory, subCategory));
        String rule = "";

        if(detail != null) {
            rule = detail.getPlanRule();
        }

        return rule;
    }

    @Override
    public PlanDescription getPlanDescription(String planId, String mainCategory, String subCategory){
        PlanDetails detail = _planMap.get(new PlanKey(planId, mainCategory, subCategory));
        PlanDescription planDescription = new PlanDescription();

        if(detail != null) {
            System.out.println(new PlanKey(planId, mainCategory, subCategory));
            planDescription = detail.getPlanDescription();
        }

        return planDescription;
    }


    private Map<PlanKey, PlanDetails> getPlanMap() {
        return _planMap;
    }
}

class PlanKey {
    private String planId;
    private String mainCategory;
    private String subCategory;

    public PlanKey(String planId, String mainCategory, String subCategory) {
        this.planId = planId;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanKey planKey = (PlanKey) o;
        return Objects.equals(planId, planKey.planId) &&
                Objects.equals(mainCategory, planKey.mainCategory) &&
                Objects.equals(subCategory, planKey.subCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, mainCategory, subCategory);
    }

    @Override
    public String toString() {
        return "PlanKey{" +
                "planId='" + planId + '\'' +
                ", mainCategory='" + mainCategory + '\'' +
                ", subCategory='" + subCategory + '\'' +
                '}';
    }
}

class PlanDetails {
    private String _planId;
    private String _planRule;
    private PlanDescription _planDescription;

    public PlanDetails(String planId, String planRule, PlanDescription planDescription) {
        _planId = planId;
        _planRule = planRule;
        _planDescription = planDescription;
    }

    public String getPlanId() {
        return _planId;
    }

    public String getPlanRule() {
        return _planRule;
    }

    public PlanDescription getPlanDescription() {
        return _planDescription;
    }

    @Override
    public String toString() {
        return "PlanDetails{" +
                "planId='" + _planId + '\'' +
                ", planRule='" + _planRule + '\'' +
                ", planDescription=" + _planDescription +
                '}';
    }
}

class SubCategory {
    private String name;
    private String pt001;
    private String pt002;
    private String pt003;

    public SubCategory(String name, String pt001, String pt002, String pt003) {
        this.name = name;
        this.pt001 = pt001;
        this.pt002 = pt002;
        this.pt003 = pt003;
    }

    public String getName() {
        return name;
    }

    public String getPt001() {
        return pt001;
    }

    public String getPt002() {
        return pt002;
    }

    public String getPt003() {
        return pt003;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pt001, that.pt001) &&
                Objects.equals(pt002, that.pt002) &&
                Objects.equals(pt003, that.pt003);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pt001, pt002, pt003);
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "name='" + name + '\'' +
                ", pt001='" + pt001 + '\'' +
                ", pt002='" + pt002 + '\'' +
                ", pt003='" + pt003 + '\'' +
                '}';
    }
}

