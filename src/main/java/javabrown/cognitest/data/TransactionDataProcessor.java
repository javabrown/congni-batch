package javabrown.cognitest.data;

import javabrown.cognitest.data.InputTransactionData;
import javabrown.cognitest.data.ProcessedTransactionData;
import javabrown.cognitest.data.mapper.PlanDescription;
import javabrown.cognitest.data.mapper.PolicyData;
import javabrown.cognitest.utils.PlanDataCache;
import javabrown.cognitest.utils.Utils;
import org.springframework.batch.item.ItemProcessor;

public class TransactionDataProcessor implements ItemProcessor<InputTransactionData, ProcessedTransactionData> {

    @Override
    public ProcessedTransactionData process(InputTransactionData item) throws Exception {

        ProcessedTransactionData output = new ProcessedTransactionData();
        PolicyData policyData =
                PlanDataCache.getInstance().getPolicyDataMap().get(Utils.getPolicyKey(item.getPolicyId(),
                        item.getPolicyHolderId()));


        output.setPolicyId(item.getPolicyId());
        output.setPolicyHolderId(item.getPolicyHolderId());
        output.setBilledAmount(item.getBilledAmount());
        output.setCoverageMainCategory(item.getCoverageMainCategory());
        output.setCoverageSubCategory(item.getCoverageSubCategory());
        output.setDateOfService(item.getDateOfService());

        if(policyData != null) {
            PlanDescription planDescription = PlanDataCache.getInstance().getPlanCoverageData().
                    getPlanDescription(policyData.getPlanId(), item.getCoverageMainCategory(), item.getCoverageSubCategory());

            String ruleApplied = PlanDataCache.getInstance().getPlanCoverageData().
                    getPlanRuleApplied(policyData.getPlanId(), item.getCoverageMainCategory(), item.getCoverageSubCategory());

            output.setPolicyHolderPays("N/A");
            output.setPlanPays("N/A");
            output.setRuleUsed(ruleApplied);
            output.setIndividualAccumulatedDeductible(policyData.getIndividualAccumulatedDeductible());
            output.setFamilyAccumulatedDeductible(policyData.getFamilyAccumulatedDeductible());
        }

        //System.out.println("Processing...OUTPUT==>[ " + output + " ]  Input ==> [ "+ item + " ]");
        return output;
    }



}