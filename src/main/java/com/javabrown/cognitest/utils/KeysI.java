package com.javabrown.cognitest.utils;

public interface KeysI {
    String CLASSPATH = "classpath";
    String BATCH_JOB_FILE = "jobs.xml";
    String BATCH_JOB = "job";
    String BATCH_JOB_LAUNCHER = "jobLauncher";
    String INPUT_TRANSACTION_FILE = "INPUT_TRANSACTION_FILE";

    String P001 = "P001";
    String P002 = "P002";
    String P003 = "P003";

    String SUCCESS_TEMPLATE = String.format("*********************************\nDone!!\nProcessed output transaction " +
                    "File ==> \"%s/processed-transaction.csv\"\n*********************************",
            System.getProperty("user.dir"));

    String FAILURE_TEMPLATE = String.format("********************************\nProcessing Failed!!\nPlease validate your" +
            " Input-Transaction-File Path/Format/Data. \n********************************");

}
