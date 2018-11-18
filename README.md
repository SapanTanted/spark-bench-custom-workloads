# spark-bench-custom-workloads
This project has all the custom workloads that we will be using in Spark R&amp;D under Prof. Umesh Bellur

Compilation command:
mvn clean package assembly:single

WORD COUNT

Input field required: inputdatafile

Other fields:

  "name" = "custom"
  
  "class" = "com.sapan.sparkbench.workload.wordcount.WordCount"
