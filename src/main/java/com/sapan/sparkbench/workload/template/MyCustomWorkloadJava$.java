package com.sapan.sparkbench.workload.template;


import com.ibm.sparktc.sparkbench.utils.GeneralFunctions;
import com.ibm.sparktc.sparkbench.utils.GeneralFunctions$;
import com.ibm.sparktc.sparkbench.utils.SaveModes;
import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.WorkloadDefaults;
import scala.*;
import scala.collection.immutable.HashMap;
import scala.collection.immutable.Map;

public class MyCustomWorkloadJava$ implements WorkloadDefaults, Serializable {
	//MODULE$ variable is compulsory
	public static final MyCustomWorkloadJava$ MODULE$ = new MyCustomWorkloadJava$();

	public static void main(String[] args) {
		System.out.println("MyCustomWorkloadJava$ => Hello World!");
	}

	@Override
	public String name() {
		return "my-custom-workload-java";
	}

	@Override
	public Workload apply(Map<String, Object> map) {
		//Take variables from map and send them to MyCustomWorkloadJava
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
		String class_ = String.valueOf(map.get("class"));
		return new MyCustomWorkloadJava(input, output, saveMode, class_);
	}
}
