package com.sapan.sparkbench.workload.template;

public class MyCustomWorkloadJavaResult {
	//Just a class to hold the final result of workload
	//This class can have other parameters as well like execution time taken by workload and so on.
	private String name;
	private String class_;

	public MyCustomWorkloadJavaResult(String name, String class_) {
		this.name = name;
		this.class_ = class_;
	}

	public String getName() {
		return name;
	}

	public String getClass_() {
		return class_;
	}
}
