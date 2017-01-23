package com.javabrown.cognitest.data;

import com.javabrown.cognitest.data.mapper.impl.PlanDescription;
import com.javabrown.cognitest.data.mapper.impl.PolicyData;
import com.javabrown.cognitest.utils.PlanDataCache;
import com.javabrown.cognitest.utils.Utils;
import org.springframework.batch.item.ItemProcessor;

import java.util.HashMap;
import java.util.Map;

public class TransactionDataProcessor implements ItemProcessor<InputTransactionData, ProcessedTransactionData> {

    private static Map<String, Double> _policyHolderDeductableTrackerMap = new HashMap<String, Double>();

    @Override
    public ProcessedTransactionData process(InputTransactionData inputPaymentTransaction) throws Exception {

        ProcessedTransactionData output = new ProcessedTransactionData();
        PolicyData policyData =
                PlanDataCache.getInstance().getPolicyDataMap().get(Utils.getPolicyKey(inputPaymentTransaction.getPolicyId(),
                        inputPaymentTransaction.getPolicyHolderId()));


        output.setPolicyId(inputPaymentTransaction.getPolicyId());
        output.setPolicyHolderId(inputPaymentTransaction.getPolicyHolderId());
        output.setBilledAmount(inputPaymentTransaction.getBilledAmount()+"");
        output.setCoverageMainCategory(inputPaymentTransaction.getCoverageMainCategory());
        output.setCoverageSubCategory(inputPaymentTransaction.getCoverageSubCategory());
        output.setDateOfService(inputPaymentTransaction.getDateOfService());

        if (policyData != null) {
            PlanDescription planDescription = PlanDataCache.getInstance().getPlanCoverageData().
                    getPlanDescription(policyData.getPlanId(), inputPaymentTransaction.getCoverageMainCategory(),
                            inputPaymentTransaction.getCoverageSubCategory());

            String ruleApplied = PlanDataCache.getInstance().getPlanCoverageData().getPlanRuleApplied(policyData.getPlanId(),
                    inputPaymentTransaction.getCoverageMainCategory(),
                    inputPaymentTransaction.getCoverageSubCategory());

            Double ruleDecuctablePercetnage = new Double(ruleApplied.replaceAll("[^\\d.]+", ""));

            Double paymentMadeByPolicyHolder = this.getPaymentByPolicyHolder(inputPaymentTransaction, policyData,
                    ruleDecuctablePercetnage);

            Double paymentMadeByPlan = this.getPaymentByPlan(inputPaymentTransaction, policyData,
                    ruleDecuctablePercetnage);

            output.setPolicyHolderPays(paymentMadeByPolicyHolder.toString());
            output.setPlanPays(paymentMadeByPlan.toString());
            output.setRuleUsed(ruleApplied);
            output.setIndividualAccumulatedDeductible(policyData.getIndividualAccumulatedDeductible()+"");
            output.setFamilyAccumulatedDeductible(policyData.getFamilyAccumulatedDeductible());
        }

        return output;
    }


    private Double getPaymentByPolicyHolder(InputTransactionData inputPaymentTransaction, PolicyData policyData,
                                         Double planPercentPaymentRatio) {
        String policyHolderId = inputPaymentTransaction.getPolicyHolderId();
        Double policyDeductablePaidByCustomer = _policyHolderDeductableTrackerMap.get(policyHolderId);

        if(policyDeductablePaidByCustomer == null){
            _policyHolderDeductableTrackerMap.put(policyHolderId, inputPaymentTransaction.getBilledAmount());
            policyDeductablePaidByCustomer = inputPaymentTransaction.getBilledAmount();
        }
        else{
            _policyHolderDeductableTrackerMap.put(policyHolderId,
                    new Double(policyDeductablePaidByCustomer + inputPaymentTransaction.getBilledAmount()));

            policyDeductablePaidByCustomer = _policyHolderDeductableTrackerMap.get(policyHolderId);
        }

        if(policyDeductablePaidByCustomer >= new Double(policyData.getIndividualAccumulatedDeductible()) ){
            Double amt = inputPaymentTransaction.getBilledAmount() * planPercentPaymentRatio / 100;
            return inputPaymentTransaction.getBilledAmount() - amt;
        }

        return inputPaymentTransaction.getBilledAmount();
    }

    private Double getPaymentByPlan(InputTransactionData inputPaymentTransaction, PolicyData policyData,
                                            Double planPercentPaymentRatio) {
        String policyHolderId = inputPaymentTransaction.getPolicyHolderId();
        Double policyDeductablePaidByCustomer = _policyHolderDeductableTrackerMap.get(policyHolderId);

        if(policyDeductablePaidByCustomer == null){
            _policyHolderDeductableTrackerMap.put(policyHolderId, inputPaymentTransaction.getBilledAmount());
            policyDeductablePaidByCustomer = inputPaymentTransaction.getBilledAmount();
        }
        else{
            _policyHolderDeductableTrackerMap.put(policyHolderId,
                    new Double(policyDeductablePaidByCustomer + inputPaymentTransaction.getBilledAmount()));

            policyDeductablePaidByCustomer = _policyHolderDeductableTrackerMap.get(policyHolderId);
        }

        if(policyDeductablePaidByCustomer >= new Double(policyData.getIndividualAccumulatedDeductible()) ){
            Double amt = inputPaymentTransaction.getBilledAmount() * planPercentPaymentRatio / 100;
            return amt;
        }

        return 0.0;
    }
}