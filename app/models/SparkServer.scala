package models

import java.io.{ByteArrayOutputStream, File, FileOutputStream}

import org.apache.spark.{SparkConf, SparkContext}

object SparkServer {
  var log = "--== LOG ==--"
  var str = new ByteArrayOutputStream()
  Console.setOut(str)
//  Console.setOut(System.out)

  val spConf = new SparkConf().setAppName("Fortune Teller API").setMaster("local[4]")
  var sc = SparkContext.getOrCreate(spConf)

  def clearLog = str.reset()

  def startServer = {
    sc = SparkContext.getOrCreate(spConf)

    println("Spark " + sc.version + " is running!")
    println("App name: " + sc.appName)
    println("Master: " + sc.master)

    log = str.toString()
  }

  def stopServer = {
    sc.stop()
    println("Spark has stopped running!")
    log = str.toString()
  }


}

