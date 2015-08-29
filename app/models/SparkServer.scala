package models

import java.io.{ByteArrayOutputStream, File, FileOutputStream}
import java.util.Calendar

import org.apache.spark.{SparkConf, SparkContext}
import play.api.libs.json.Json

object SparkServer {

  case class Status(time:String, message:String)

  implicit val statusWrites = Json.writes[Status]
  implicit val statusReads = Json.reads[Status]

  //var status = List(Status) //("", "", "", "Spark server initialized", "INIT"))
 // status.log +: "--== LOG ==--"

  var log = List(Status(Calendar.getInstance().getTime().toString, "Spark is initialized."))

  var str = new ByteArrayOutputStream()
  Console.setOut(str)
//  Console.setOut(System.out)

  val spConf = new SparkConf().setAppName("Fortune Teller API").setMaster("local[4]")
  var sc = SparkContext.getOrCreate(spConf)

  def clearLog = str.reset()

  def startServer = {
    sc = SparkContext.getOrCreate(spConf)

   // status = status :: new Status(sc.version, sc.appName, sc.master, "Spark is running!", "START")

    //status.log += str.toString()
    log = log ::: List(Status(Calendar.getInstance().getTime().toString, "Spark is running!"))

  }

  def stopServer = {
    sc.stop()
    //println("Spark has stopped running!")
    //status = status :: new Status(sc.version, sc.appName, sc.master, "Spark has stopped running!", "STOP")

    //log = log.::("STOP")
    log = log ::: List(Status(Calendar.getInstance().getTime().toString, "Spark has stopped running!"))


    //status.log += str.toString()
  }

}

