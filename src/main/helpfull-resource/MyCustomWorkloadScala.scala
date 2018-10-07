package com.sapan.scala.example

import com.ibm.sparktc.sparkbench.workload.{Workload, WorkloadDefaults}
import com.ibm.sparktc.sparkbench.utils.GeneralFunctions._
import org.apache.spark.sql.{DataFrame, SparkSession}

case class MyCustomWorkloadScalaResult(name: String, start_time: Long, total_runtime: Long, word: String)

object MyCustomWorkloadScala extends WorkloadDefaults {
  val name = "my-custom-workload-scala"

  override def apply(m: Map[String, Any]) = MyCustomWorkloadScala(
    word = getOrThrow(m, "word").asInstanceOf[String]
  )

  def main(args: Array[String]): Unit = {
    println("hello world scala")
  }
}


case class MyCustomWorkloadScala(word: String,
                                 input: Option[String] = None,
                                 output: Option[String] = None,
                                 saveMode: String = null
                                ) extends Workload {

  override def doWorkload(df: Option[DataFrame] = None, sparkSession: SparkSession): DataFrame = {
    val timestamp = System.currentTimeMillis()
    val (total_time, _) = time {
      for (x <- 1 to 10) {
        println("-----" + word + "------")
      }
      null
    }
    sparkSession.createDataFrame(Seq(MyCustomWorkloadScalaResult("my-custom-workload-scala", timestamp, total_time, word)))
  }

}