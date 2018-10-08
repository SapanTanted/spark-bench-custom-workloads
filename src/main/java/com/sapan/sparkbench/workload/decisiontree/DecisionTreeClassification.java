package com.sapan.sparkbench.workload.decisiontree;


import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.Workload$class;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.classification.DecisionTreeClassificationModel;
import org.apache.spark.ml.classification.DecisionTreeClassifier;
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator;
import org.apache.spark.ml.feature.*;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Option;
import scala.Serializable;
import scala.collection.immutable.Map;

import java.util.ArrayList;

public class DecisionTreeClassification implements Workload,Serializable{
	//compulsory parameters
	private Option<String> input,output;
	private String saveMode;
	//parameters sent from spark-bench
	private String inputDataFile;
	private String dataFormat;
	public DecisionTreeClassification(Option<String> input, Option<String> output, String saveMode, String inputDataFile,String dataFormat) {
		this.input = input;
		this.output = output;
		this.saveMode = saveMode;
		//Other parameters sent through spark-bench config
		this.inputDataFile = inputDataFile;
		this.dataFormat= dataFormat;
		Workload$class.$init$(this);
	}

	@Override
	public Dataset<Row> doWorkload(Option<Dataset<Row>> inputDataSet, SparkSession sparkSession) {
		//inputDataSet is the dataset that came from {this.input} file

		/*
		write your code here
		 */
		SparkSession spark = SparkSession
				.builder()
				.appName("DecisionTreeClassification")
				.getOrCreate();

		// $example on$
		// Load the data stored in LIBSVM format as a DataFrame.
		Dataset<Row> data = spark
				.read()
				.format(this.dataFormat)
				.load(this.inputDataFile);

		// Index labels, adding metadata to the label column.
		// Fit on whole dataset to include all labels in index.
		StringIndexerModel labelIndexer = new StringIndexer()
				.setInputCol("label")
				.setOutputCol("indexedLabel")
				.fit(data);

		// Automatically identify categorical features, and index them.
		VectorIndexerModel featureIndexer = new VectorIndexer()
				.setInputCol("features")
				.setOutputCol("indexedFeatures")
				.setMaxCategories(4) // features with > 4 distinct values are treated as continuous.
				.fit(data);

		// Split the data into training and test sets (30% held out for testing).
		Dataset<Row>[] splits = data.randomSplit(new double[]{0.7, 0.3});
		Dataset<Row> trainingData = splits[0];
		Dataset<Row> testData = splits[1];

		// Train a DecisionTree model.
		DecisionTreeClassifier dt = new DecisionTreeClassifier()
				.setLabelCol("indexedLabel")
				.setFeaturesCol("indexedFeatures");

		// Convert indexed labels back to original labels.
		IndexToString labelConverter = new IndexToString()
				.setInputCol("prediction")
				.setOutputCol("predictedLabel")
				.setLabels(labelIndexer.labels());

		// Chain indexers and tree in a Pipeline.
		Pipeline pipeline = new Pipeline()
				.setStages(new PipelineStage[]{labelIndexer, featureIndexer, dt, labelConverter});

		// Train model. This also runs the indexers.
		PipelineModel model = pipeline.fit(trainingData);

		// Make predictions.
		Dataset<Row> predictions = model.transform(testData);

		// Select example rows to display.
		predictions.select("predictedLabel", "label", "features").show(5);

		// Select (prediction, true label) and compute test error.
		MulticlassClassificationEvaluator evaluator = new MulticlassClassificationEvaluator()
				.setLabelCol("indexedLabel")
				.setPredictionCol("prediction")
				.setMetricName("accuracy");
		double accuracy = evaluator.evaluate(predictions);
		System.out.println("Test Error = " + (1.0 - accuracy));
		double testError = (1.0-accuracy);

		DecisionTreeClassificationModel treeModel =
				(DecisionTreeClassificationModel) (model.stages()[2]);
		System.out.println("Learned classification tree model:\n" + treeModel.toDebugString());
		String modelDebugString = treeModel.toDebugString();
		// $example off$

		ArrayList<DecisionTreeClassificationResult> decisionTreeClassificationResults = new ArrayList<>();
		decisionTreeClassificationResults.add(new DecisionTreeClassificationResult("DecisionTreeClassification",this.inputDataFile, dataFormat, testError, modelDebugString));
		Dataset<Row> resultDataSet = sparkSession.createDataFrame(decisionTreeClassificationResults, DecisionTreeClassificationResult.class);
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
		System.out.println("DecisionTreeClassification => Hello World!");
	}
}
