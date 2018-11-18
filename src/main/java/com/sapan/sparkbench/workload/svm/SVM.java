package com.sapan.sparkbench.workload.svm;


import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.Workload$class;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.classification.SVMModel;
import org.apache.spark.mllib.classification.SVMWithSGD;
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.util.MLUtils;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.storage.StorageLevel;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.immutable.Map;

import java.util.ArrayList;

public class SVM implements Workload,Serializable{
	//compulsory parameters
	private Option<String> input,output;
	private String saveMode;
	//parameters sent from spark-bench
	private int numIterations;
//	private String storage_level;
	private String inputDataFile;
	public SVM(Option<String> input,Option<String> output, String saveMode,String numIterations,String inputDataFile) {
		this.input = input;
		this.output = output;
		this.saveMode = saveMode;
		//Other parameters sent through spark-bench config
		this.numIterations = Integer.parseInt(numIterations);
//		this.storage_level=storage_level;
		this.inputDataFile=inputDataFile;
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
		SparkContext sc = sparkSession.sparkContext();
		// $example on$
		String path = inputDataFile;
		JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(sc, path).toJavaRDD();

		// Split initial RDD into two... [60% training data, 40% testing data].
		JavaRDD<LabeledPoint> training = data.sample(false, 0.6, 11L);
		training.cache();
		JavaRDD<LabeledPoint> test = data.subtract(training);

		// Run training algorithm to build the model.
//		int numIterations = 100;
		SVMModel model = SVMWithSGD.train(training.rdd(), numIterations);

		// Clear the default threshold.
		model.clearThreshold();

		// Compute raw scores on the test set.
		JavaRDD<Tuple2<Object, Object>> scoreAndLabels = test.map(p ->
				new Tuple2<>(model.predict(p.features()), p.label()));

		// Get evaluation metrics.
		BinaryClassificationMetrics metrics =
				new BinaryClassificationMetrics(JavaRDD.toRDD(scoreAndLabels));
		double auROC = metrics.areaUnderROC();

		System.out.println("Area under ROC = " + auROC);

		// Save and load model
		model.save(sc, "target/tmp/javaSVMWithSGDModel");
		SVMModel sameModel = SVMModel.load(sc, "target/tmp/javaSVMWithSGDModel");
		// System.out.println("training Weight = " +
		//           Arrays.toString(model.weights().toArray()));
		ArrayList<SVMResult> myCustomWorkloadJavaResults = new ArrayList<>();
		myCustomWorkloadJavaResults.add(new SVMResult("SVM",this.inputDataFile,this.numIterations));
		Dataset<Row> resultDataSet = sparkSession.createDataFrame(myCustomWorkloadJavaResults, SVMResult.class);
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
		System.out.println("SVM => Hello World!");
	}
}
