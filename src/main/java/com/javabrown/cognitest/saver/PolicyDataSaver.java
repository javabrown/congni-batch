package com.javabrown.cognitest.saver;

import com.javabrown.cognitest.utils.PlanDataCache;
import com.javabrown.cognitest.data.mapper.PolicyData;
import com.javabrown.cognitest.utils.Utils;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class PolicyDataSaver implements ItemWriter<PolicyData> {
    @Override
    public void write(List<? extends PolicyData> policies) throws Exception {
        policies.forEach((policy) -> {
            PlanDataCache.getInstance().getPolicyDataMap().put(
                    Utils.getPolicyKey(policy.getPolicyId(), policy.getPolicyHolderId()), policy);
        });
    }
}