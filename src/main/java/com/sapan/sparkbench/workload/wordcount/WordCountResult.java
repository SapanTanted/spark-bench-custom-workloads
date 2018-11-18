package com.sapan.sparkbench.workload.wordcount;

public class WordCountResult {
	//Just a class to hold the final result of workload
	//This class can have other parameters as well like execution time taken by workload and so on.
	private String name;
	private String inputDataFile;
	private String res;


	public WordCountResult(String name, String inputDataFile,String res) {
		this.name = name;
		this.inputDataFile = inputDataFile;
		this.res = res;
	}
	public String getRes() { return res; }

	public String getName() {
		return name;
	}

	public String getInputDataFile() {
		return inputDataFile;
	}

}
