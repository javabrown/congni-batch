# congni-batch

Application to evaluate multiple data files(csv) in spring batch process and returnd the processd result.

Usage:



1) Build the application:

    $ gradlew clean build shadowJar


2) Run the executable jar:

    $ java -jar build/libs/congni-batch-1.0-all.jar file:///./input-transaction-data.csv

   Result:

    *********************************
    Done!!
    Processed output transaction File ==> "user/local/test/congni-batch/processed-transaction.csv"
    *********************************
