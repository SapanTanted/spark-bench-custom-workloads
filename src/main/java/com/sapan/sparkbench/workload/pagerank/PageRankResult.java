package com.sapan.sparkbench.workload.pagerank;

public class PageRankResult {
	//Just a class to hold the final result of workload
	//This class can have other parameters as well like execution time taken by workload and so on.
	private String name;
	private String inputDataFile;
	private int numIterations;
	private String modelDebugString;


	public PageRankResult(String name, String inputDataFile,  int numIterations, String modelDebugString) {
		this.name = name;
		this.inputDataFile = inputDataFile;
		this.numIterations = numIterations;
		this.modelDebugString = modelDebugString;
	}

	public double getTestError() {
		return numIterations;
	}

	public String getModelDebugString() {
		return modelDebugString;
	}

	public String getName() {
		return name;
	}

	public String getInputDataFile() {
		return inputDataFile;
	}

}
