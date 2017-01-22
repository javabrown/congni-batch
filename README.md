# congni-batch

Test application to evaluate multiple csv-formatted data files using spring-batch and returnd the processed result.

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
