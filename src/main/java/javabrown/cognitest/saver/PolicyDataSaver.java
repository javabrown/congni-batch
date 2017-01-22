package javabrown.cognitest.saver;

import javabrown.cognitest.utils.PlanDataCache;
import javabrown.cognitest.data.mapper.PolicyData;
import javabrown.cognitest.utils.Utils;
import org.springframework.batch.item.ItemWriter;
import java.util.List;

public class PolicyDataSaver implements ItemWriter<PolicyData> {
    @Override
    public void write(List<? extends PolicyData> policies) throws Exception {
        policies.forEach((policy)->{
            PlanDataCache.getInstance().getPolicyDataMap().put(
                    Utils.getPolicyKey(policy.getPolicyId(), policy.getPolicyHolderId()), policy);
        });
    }
}