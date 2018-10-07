package com.sapan.java.example;


import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.Workload$class;
import com.ibm.sparktc.sparkbench.workload.WorkloadDefaults;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Function1;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.immutable.Map;

public class MyCustomWorkloadJava$ implements WorkloadDefaults,Serializable{

	public static final MyCustomWorkloadJava$ MODULE$= new MyCustomWorkloadJava$();

	public static void main(String[] args) {
		System.out.println("MyCustomWorkloadJava$ Hello World!");
		System.out.println(((Option<String>)new Some<String>("[\"hdfs:///tmp/csv-vs-parquet/kmeans-data.csv\", \"hdfs:///tmp/csv-vs-parquet/kmeans-data.parquet\"]")).get());
	}

	@Override
	public String name() {
		return "my-custom-workload-java";
	}

	@Override
	public Workload apply(Map<String, Object> map) {
		return new MyCustomWorkloadJava();
	}
}
