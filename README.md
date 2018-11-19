# spark-bench-custom-workloads
This project has all the custom workloads that we will be using in Spark R&amp;D under Prof. Umesh Bellur

###Compilation command:
mvn clean package

###CUSTOM WORKLOADS REFERENCE
####Word Count
**Class Name**: "com.sapan.sparkbench.workload.wordcount.WordCount"\
**Parameters**:
"name":"custom"\
"class":"com.sapan.sparkbench.workload.wordcount.WordCount"\
“inputdatafile” : “path/to/the/input/file”

####Page Rank
**Class Name**: "com.sapan.sparkbench.workload.pagerank.PageRank"\
**Parameters**:\
"name":"custom"\
"class":"com.sapan.sparkbench.workload.pagerank.PageRank"\
“inputdatafile” : “path/to/the/input/file”\
“numiterations” : “number of iterations to run in quotes”

Input should be a text file with following format:\
URL  neighbour URL\
URL  neighbour URL\
…..\
URL  neighbour URL\
The URL and neighbouring URL must be seperated by spaces

####SVM
**Class Name**: "com.sapan.sparkbench.workload.svm.SVM”\
**Parameters**:\
"name":"custom"\
"class":"com.sapan.sparkbench.workload.svm.SVM”\
“inputdatafile” : “path/to/the/input/file”\
“numiterations” : “number of iterations to run in quotes”

Input file should be a text file with data in libsvm format

####Decision Tree
**Class Name**: "com.sapan.sparkbench.workload.decisiontree.DecisionTreeClassification”\
**Parameters**:\
"name":"custom"\
"class":"com.sapan.sparkbench.workload.decisiontree.DecisionTreeClassification”\
“inputdatafile” : “path/to/the/input/file”\
“dataformat” : “format of data (preferably libsvm)”

###Miscellaneous
Some helpful resources are available in src/main/helpful-resource folder.
It also contains some sample configs for some workloads.
