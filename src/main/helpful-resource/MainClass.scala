package com.sapan.scala.example

import com.ibm.sparktc.sparkbench.workload.WorkloadDefaults

/**
 * @author ${user.name}
 */
object MainClass {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)


  def main(args : Array[String]) {
    println("MainClass Hello World!")
  }

}
