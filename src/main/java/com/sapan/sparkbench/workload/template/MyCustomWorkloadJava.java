package com.sapan.sparkbench.workload.template;


import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.Workload$class;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Option;
import scala.Serializable;
import scala.collection.immutable.Map;

import java.util.ArrayList;

public class MyCustomWorkloadJava implements Workload,Serializable{
	//compulsory parameters
	private Option<String> input,output;
	private String saveMode;
	//parameters sent from spark-bench
	private String class_;
	public MyCustomWorkloadJava(Option<String> input,Option<String> output, String saveMode,String class_) {
		this.input = input;
		this.output = output;
		this.saveMode = saveMode;
		//Other parameters sent through spark-bench config
		this.class_ = class_;
		Workload$class.$init$(this);
	}

	@Override
	public Dataset<Row> doWorkload(Option<Dataset<Row>> inputDataSet, SparkSession sparkSession) {
		//inputDataSet is the dataset that came from {this.input} file

		/*
		write your code here

		for(int i=0;i<100;i++)
		{
			System.out.println("do Workload....");
		}
		 */

		ArrayList<MyCustomWorkloadJavaResult> myCustomWorkloadJavaResults = new ArrayList<>();
		myCustomWorkloadJavaResults.add(new MyCustomWorkloadJavaResult("MyCustomWorkloadJava",this.class_));
		Dataset<Row> resultDataSet = sparkSession.createDataFrame(myCustomWorkloadJavaResults, MyCustomWorkloadJavaResult.class);
		//this function should return exactly one row dataset.
		return resultDataSet;//this dataframe will get written to {this.output} file
	}

	@Override
	public Dataset<Row> run(SparkSession sparkSession) {
		return Workload$class.run(this,sparkSession);
	}

	@Override
	public Map<String, Object> toMap() {
		return Workload$class.toMap(this);
	}

	@Override
	public Option<String> input() {
		return this.input;
	}

	@Override
	public Option<String> output() {
		return this.output;
	}

	@Override
	public String saveMode() {
		return this.saveMode;
	}

	@Override
	public Dataset<Row> reconcileSchema(Dataset<Row> dataset) {
		return Workload$class.reconcileSchema(this,dataset);
	}

	public static void main(String[] args) {
		System.out.println("MyCustomWorkloadJava => Hello World!");
	}
}
