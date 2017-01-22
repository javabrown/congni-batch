package javabrown.cognitest.saver;

import javabrown.cognitest.data.mapper.PlanCoverageData;
import javabrown.cognitest.utils.PlanDataCache;
import org.springframework.batch.item.ItemWriter;
import java.util.List;

public class PlanCoverageSaver implements ItemWriter<PlanCoverageData> {
    private static String  _tmpMainCategory = "";

    @Override
    public void write(List<? extends PlanCoverageData> items) throws Exception {

        items.forEach((coverage)->{
            if(coverage.isEmpty()){
                return;
            }

            if(coverage.isMainCategory()){
                _tmpMainCategory = coverage.getMainCategory();
                PlanDataCache.getInstance().getPlanCoverageData().createNewMainCaregory(_tmpMainCategory);
            }
            else {
                PlanDataCache.getInstance().getPlanCoverageData().addSubCategoryUnderMainCaregory(_tmpMainCategory,
                        coverage.makeSubCategory());
            }
        });

    }

    private boolean isMainCategory(PlanCoverageData data){
        return data.getMainCategory() != null &&  data.getMainCategory().trim().length() > 0;
    }

    private boolean isEmptyRow(PlanCoverageData data){
        return data.getMainCategory() != null &&  data.getMainCategory().trim().length() > 0;
    }
}