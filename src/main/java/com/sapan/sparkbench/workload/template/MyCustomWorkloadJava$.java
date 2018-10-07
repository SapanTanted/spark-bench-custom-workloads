package com.sapan.sparkbench.workload.template;


import com.ibm.sparktc.sparkbench.utils.SaveModes;
import com.ibm.sparktc.sparkbench.workload.Workload;
import com.ibm.sparktc.sparkbench.workload.WorkloadDefaults;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.collection.immutable.Map;

public class MyCustomWorkloadJava$ implements WorkloadDefaults, Serializable {

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
		Option<String> input = map.get("input") != null ? new Some(map.get("input")) : Option.empty();
		Option<String> output = map.get("output") != null ? new Some(map.get("output")) : Option.empty();
		String saveMode = map.get("saveMode") != null ? String.valueOf(map.get("saveMode")) : SaveModes.error();
		//non-compulsory parameters
		String class_ = String.valueOf(map.get("class"));
		return new MyCustomWorkloadJava(input, output, saveMode, class_);
	}
}
