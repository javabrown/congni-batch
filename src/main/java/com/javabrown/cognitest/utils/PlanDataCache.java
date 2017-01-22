package com.javabrown.cognitest.utils;

import com.javabrown.cognitest.data.mapper.PlanCoverage;
import com.javabrown.cognitest.data.mapper.PlanCoverageI;
import com.javabrown.cognitest.data.mapper.PlanDescription;
import com.javabrown.cognitest.data.mapper.PolicyData;

import java.util.HashMap;
import java.util.Map;

public class PlanDataCache {
    private static PlanDataCache _instance;

    private PlanCoverage _planCoverageData;
    private Map<String, PlanDescription> _planDescriptionMap;
    private Map<String, PolicyData> _policyDataMap;

    private PlanDataCache() {
        _planCoverageData = new PlanCoverage();
        _planDescriptionMap = new HashMap<String, PlanDescription>();
        _policyDataMap = new HashMap<String, PolicyData>();
    }

    public static synchronized PlanDataCache getInstance() {
        if (_instance == null) {
            _instance = new PlanDataCache();
        }

        return _instance;
    }

    public PlanCoverageI getPlanCoverageData() {
        return _planCoverageData;
    }

    public Map<String, PlanDescription> getPlanDescriptionMap() {
        return _planDescriptionMap;
    }

    public Map<String, PolicyData> getPolicyDataMap() {
        return _policyDataMap;
    }
}
