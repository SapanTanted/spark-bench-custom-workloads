package com.sapan.sparkbench.workload.pagerank;


import com.ibm.sparktc.sparkbench.utils.GeneralFunctions;
import com.ibm.sparktc.sparkbench.utils.SaveModes;
import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.WorkloadDefaults;
import scala.Option;
import scala.Serializable;
import scala.collection.immutable.Map;

public class PageRank$ implements WorkloadDefaults, Serializable {
	//MODULE$ variable is compulsory
	public static final PageRank$ MODULE$ = new PageRank$();

	public static void main(String[] args) {
		System.out.println("PageRank$ => Hello World!");
	}

	@Override
	public String name() {
		return "page-rank";
	}

	@Override
	public Workload apply(Map<String, Object> map) {
		//Take variables from map and send them to DecisionTreeClassification
		/*  Map<String, Object>.
		This will be the form you receive your parameters in from the spark-bench infrastructure.
		Example:
		     Map(
		           "name" -> "word-generator",
                   "output" -> "/tmp/one-word-over-and-over.csv",
                   "word" -> "Cool"
                )
        Keep in mind that the keys in your map have been toLowerCase()'d for consistency.
        */
		//compulsory parameters
		Option<String> input = GeneralFunctions.optionallyGet(map, "input");
		Option<String> output = GeneralFunctions.optionallyGet(map, "output");
		Option<String> saveModeOption = GeneralFunctions.optionallyGet(map, "savemode");
		String saveMode = saveModeOption.isEmpty() ? SaveModes.error() : saveModeOption.get();
		//non-compulsory parameters
		//Keep in mind that the keys in your map have been toLowerCase()'d for consistency
		String inputDataFile = GeneralFunctions.getOrThrow(map,"inputdatafile") + "";
		String nI=GeneralFunctions.getOrThrow(map,"numiterations") + "";
		return new PageRank(input, output, saveMode, inputDataFile, nI);
	}
}
