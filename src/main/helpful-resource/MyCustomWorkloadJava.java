package com.sapan.java.example;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.collection.immutable.*;
import com.ibm.sparktc.sparkbench.utils.*;
import scala.*;
import com.ibm.sparktc.sparkbench.workload.*;

public class MyCustomWorkloadJava implements Workload,Serializable{

	public static void main(String[] args) {
		System.out.println("DecisionTreeClassification Hello World!");
	}

	public MyCustomWorkloadJava() {
		Workload$class.$init$(this);
	}

	@Override
	public Option<String> input() {
		return Option.empty();
	}

	@Override
	public Option<String> output() {
		return Option.empty();
	}

	@Override
	public String saveMode() {
		return SaveModes.overwrite();
	}

	@Override
	public Dataset<Row> reconcileSchema(Dataset<Row> dataset) {
		return Workload$class.reconcileSchema(this,dataset);
	}

	@Override
	public Dataset<Row> doWorkload(Option<Dataset<Row>> option, SparkSession sparkSession) {
		for(int i=0;i<1000;i++)
		{
			System.out.println("do Workload....");
		}
		return sparkSession.emptyDataFrame();
	}

	@Override
	public Dataset<Row> run(SparkSession sparkSession) {
		return Workload$class.run(this,sparkSession);
	}

	@Override
	public Map<String, Object> toMap() {
		return Workload$class.toMap(this);
	}

}
