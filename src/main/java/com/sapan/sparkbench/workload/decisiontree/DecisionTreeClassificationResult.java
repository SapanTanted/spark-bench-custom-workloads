package com.sapan.sparkbench.workload.decisiontree;

public class DecisionTreeClassificationResult {
	//Just a class to hold the final result of workload
	//This class can have other parameters as well like execution time taken by workload and so on.
	private String name;
	private String inputDataFile;
	private String dataFormat;
	private double testError;
	private String modelDebugString;


	public DecisionTreeClassificationResult(String name, String inputDataFile, String dataFormat, double testError, String modelDebugString) {
		this.name = name;
		this.inputDataFile = inputDataFile;
		this.dataFormat = dataFormat;
		this.testError = testError;
		this.modelDebugString = modelDebugString;
	}

	public double getTestError() {
		return testError;
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

	public String getDataFormat() {
		return dataFormat;
	}

}
