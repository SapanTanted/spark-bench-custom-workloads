package com.sapan.sparkbench.workload.pagerank;


import com.google.common.collect.Iterables;
import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.Workload$class;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
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
import scala.Tuple2;
import scala.collection.immutable.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PageRank implements Workload,Serializable{
	//compulsory parameters
	private Option<String> input,output;
	private String saveMode;
	//parameters sent from spark-bench
	private String inputDataFile;
	private int numIterations;
	public PageRank(Option<String> input, Option<String> output, String saveMode, String inputDataFile,String numIterations) {
		this.input = input;
		this.output = output;
		this.saveMode = saveMode;
		//Other parameters sent through spark-bench config
		this.inputDataFile = inputDataFile;
		this.numIterations=Integer.parseInt(numIterations);
		Workload$class.$init$(this);
	}
//	private static final Pattern SPACES = Pattern.compile("\\s+");

	static void showWarning() {
		String warning = "WARN: This is a naive implementation of PageRank " +
				"and is given as an example! \n" +
				"Please use the PageRank implementation found in " +
				"org.apache.spark.graphx.lib.PageRank for more conventional use.";
		System.err.println(warning);
	}

	private static class Sum implements Function2<Double, Double, Double> {
		@Override
		public Double call(Double a, Double b) {
			return a + b;
		}
	}

	@Override
	public Dataset<Row> doWorkload(Option<Dataset<Row>> inputDataSet, SparkSession sparkSession) {
		//inputDataSet is the dataset that came from {this.input} file

		/*
		write your code here
		 */
		showWarning();

		SparkSession spark = SparkSession
				.builder()
				.appName("JavaPageRank")
				.getOrCreate();

		// Loads in input file. It should be in format of:
		//     URL         neighbor URL
		//     URL         neighbor URL
		//     URL         neighbor URL
		//     ...
		JavaRDD<String> lines = spark.read().textFile(inputDataFile).javaRDD();

		// Loads all URLs from input file and initialize their neighbors.
		JavaPairRDD<String, Iterable<String>> links = lines.mapToPair(s -> {
			String[] parts = s.split("\\s+");
			return new Tuple2<>(parts[0], parts[1]);
		}).distinct().groupByKey().cache();

		// Loads all URLs with other URL(s) link to from input file and initialize ranks of them to one.
		JavaPairRDD<String, Double> ranks = links.mapValues(rs -> 1.0);

		// Calculates and updates URL ranks continuously using PageRank algorithm.
		for (int current = 0; current < (numIterations); current++) {
			// Calculates URL contributions to the rank of other URLs.
			JavaPairRDD<String, Double> contribs = links.join(ranks).values()
					.flatMapToPair(s -> {
						int urlCount = Iterables.size(s._1());
						List<Tuple2<String, Double>> results = new ArrayList<>();
						for (String n : s._1) {
							results.add(new Tuple2<>(n, s._2() / urlCount));
						}
						return results.iterator();
					});

			// Re-calculates URL ranks based on neighbor contributions.
			ranks = contribs.reduceByKey(new Sum()).mapValues(sum -> 0.15 + sum * 0.85);
		}

		// Collects all URL ranks and dump them to console.
		List<Tuple2<String, Double>> output = ranks.collect();
		for (Tuple2<?,?> tuple : output) {
			System.out.println(tuple._1() + " has rank: " + tuple._2() + ".");
		}
		// $example off$
		double testError=0.0;
		String modelDebugString="";
		ArrayList<PageRankResult> decisionTreeClassificationResults = new ArrayList<>();
		decisionTreeClassificationResults.add(new PageRankResult("PageRank",this.inputDataFile,(numIterations), modelDebugString));
		Dataset<Row> resultDataSet = sparkSession.createDataFrame(decisionTreeClassificationResults, PageRankResult.class);
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
		System.out.println("PageRank => Hello World!");
	}
}
