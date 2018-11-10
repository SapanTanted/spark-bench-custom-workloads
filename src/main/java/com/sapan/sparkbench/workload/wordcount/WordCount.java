package com.sapan.sparkbench.workload.wordcount;


import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.Workload$class;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.ArrayList;


import scala.Option;
import scala.Serializable;
import scala.Tuple2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;
import scala.collection.immutable.Map;

import java.util.Arrays;
import java.util.List;

public class WordCount implements Workload, Serializable {
	//compulsory parameters
	private Option<String> input,output;
	private String saveMode;
	//parameters sent from spark-bench
	private String inputDataFile;

	public WordCount(Option<String> input, Option<String> output, String saveMode, String inputDataFile) {
		this.input = input;
		this.output = output;
		this.saveMode = saveMode;
		//Other parameters sent through spark-bench config
		this.inputDataFile = inputDataFile;
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
				.appName("JavaWordCount")
				.getOrCreate();

		JavaRDD<String> lines = spark.read().textFile(inputDataFile).javaRDD();

		JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(s.split(" ")).iterator());

		JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

		JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);

		List<Tuple2<String, Integer>> output = counts.collect();
		String res="Result is not printed and not sent as output. Because It can be too large for big files.";
//		for (Tuple2<?,?> tuple : output) {
//			System.out.println(tuple._1() + ": " + tuple._2());
//			res+=(tuple._1() + ": " + tuple._2());
//		}
		// $example off$

		ArrayList<WordCountResult> wordCountResults = new ArrayList<>();
		wordCountResults.add(new WordCountResult("WordCount",this.inputDataFile, res));
		Dataset<Row> resultDataSet = sparkSession.createDataFrame(wordCountResults, WordCountResult.class);
		//this function should return exactly one row dataset.
		return resultDataSet;//this dataframe will get written to {this.res} file
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
		System.out.println("WordCount => Hello World!");
	}
}
