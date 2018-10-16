package com.sapan.sparkbench.workload.svm;

public class SVMResult {
	//Just a class to hold the final result of workload
	//This class can have other parameters as well like execution time taken by workload and so on.
	private String name;
	private String inputDataFile;
	private  int numIterations;
	private String storage_level;

	public SVMResult(String name, String inputDataFile,int numIterations) {
		this.name = name;
		this.inputDataFile=inputDataFile;
		this.numIterations=numIterations;
//		this.storage_level=storage_level;
	}

	public String getName() {
		return name;
	}

	public String getInputDataFile() {
		return inputDataFile;
	}

	public int getNumIterations() {return numIterations;}

//	public String getStorage_level() {return storage_level;}
}
