package com.javabrown.cognitest.saver;

import java.util.List;

import com.javabrown.cognitest.utils.PlanDataCache;
import com.javabrown.cognitest.data.mapper.PlanDescription;
import org.springframework.batch.item.ItemWriter;

public class PlanDescriptionSaver implements ItemWriter<PlanDescription> {
    @Override
    public void write(List<? extends PlanDescription> items) throws Exception {
        items.forEach((v) -> {
            PlanDataCache.getInstance().getPlanDescriptionMap().put(v.getPlanId(), v);
        });
    }
}