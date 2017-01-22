package javabrown.cognitest;

import javabrown.cognitest.data.mapper.PlanDescription;
import javabrown.cognitest.utils.KeysI;
import javabrown.cognitest.utils.PlanDataCache;
import javabrown.cognitest.utils.Utils;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static javabrown.cognitest.utils.KeysI.*;

public class Runner {

  public static void main(String[] args) {
    System.out.println("===============> " + args.length);

    if(args.length > 0) {
        System.setProperty(INPUT_TRANSACTION_FILE, args[0]);
        //Utils.disableConsoleOutput();
    }
    else{
        System.err.printf(FAILURE_TEMPLATE);
        System.exit(1);
    }

    ApplicationContext context= new ClassPathXmlApplicationContext( String.format("%s:%s", CLASSPATH, BATCH_JOB_FILE));
    JobLauncher jobLauncher = (JobLauncher) context.getBean(BATCH_JOB_LAUNCHER);

    Job job = (Job) context.getBean(BATCH_JOB);

    try {
        JobExecution execution = jobLauncher.run(job, new JobParameters());

        Map<String, PlanDescription> planMap = PlanDataCache.getInstance().getPlanDescriptionMap();
        for (String id : planMap.keySet()) {
           System.out.println(id + ":" + planMap.get(id).toString());
        }

//        Map planMap1 = PlanDataCache.getInstance().getPlanCoverageData().getPlanMap();
//        System.out.println("Coverage Data Size:" + planMap1.size());
//
//        planMap1.forEach((k, v)->{
//            System.out.println(k + ":" + v.toString());
//        });
//
//        planMap1 = PlanDataCache.getInstance().getPolicyDataMap();
//        System.out.println("Policy Data Size:" + planMap1.size());
//
//        planMap1.forEach((k, v)->{
//            System.out.println(k + ":" + v.toString());
//        });

        Utils.enableConsoleOutput();
        if(execution.getExitStatus().equals(ExitStatus.COMPLETED)) {
            System.out.println(SUCCESS_TEMPLATE);
        }
        else{
            System.err.println(FAILURE_TEMPLATE);
        }


    } catch (Exception e) {
        e.printStackTrace();
    }
  }

    static String inputTransactionFile;
}