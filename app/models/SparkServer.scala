package models

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by Bas on 28-8-2015.
 */
object SparkServer {

  val spConf = new SparkConf().setAppName("Simple Project").setMaster("local[4]")

  val spCtx = SparkContext.getOrCreate(spConf)

}

