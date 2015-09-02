package models

import java.io.ByteArrayOutputStream
import java.util.Calendar
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.regression.{LinearRegressionModel, LabeledPoint, LinearRegressionWithSGD}
import play.api.libs.json.Json
import org.apache.spark.mllib.linalg._

object SparkEngine {
  val spConf = new SparkConf().setAppName("Fortune Teller API").setMaster("local[*]")
  var spCtx = SparkContext.getOrCreate(spConf)
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)

  case class Status(time:String, message:String)
  implicit val statusWrites = Json.writes[Status]
  implicit val statusReads = Json.reads[Status]

  case class Person(familySize:Integer, kids:Integer, education:Integer)

  var log = List(Status(Calendar.getInstance().getTime().toString, "Spark is initialized."))

  var str = new ByteArrayOutputStream()
  Console.setOut(str)

  def sc = spCtx

  def startServer = {
    spCtx = SparkContext.getOrCreate(spConf)
    log = log ::: List(Status(Calendar.getInstance().getTime().toString, "Spark is running!"))
  }

  def stopServer = {
    sc.stop()
    log = log ::: List(Status(Calendar.getInstance().getTime().toString, "Spark has stopped running!"))
  }

  def clearLog = str.reset()

  var model_health:LinearRegressionModel = _
  var model_wealth:LinearRegressionModel = _

  def getCorrelations = Statistics.corr(Survey.vectors, "pearson").toString()

  def train(saveModel:Boolean): Unit = {
    // Health
    val data_health = Survey.surveys.map(record => LabeledPoint(record.Health, Vectors.dense(record.FamilySize/10, record.Kids/10, record.Education/10))).collect()
    val rdd_health = sc.makeRDD(data_health)

    val splits_health = rdd_health.randomSplit(Array(0.8, 0.2))
    val training_health = splits_health(0).cache()

    val algorithm_health = new LinearRegressionWithSGD()
    algorithm_health.setIntercept(true)
    model_health = algorithm_health.run(training_health)

    // Wealth
    val data_wealth = Survey.surveys.map(record => LabeledPoint(record.Wealth/10, Vectors.dense(record.FamilySize/10, record.Kids/10, record.Education/10))).collect()
    val rdd_wealth = sc.makeRDD(data_wealth)

    val splits_wealth = rdd_wealth.randomSplit(Array(0.8, 0.2))
    val training_wealth = splits_wealth(0).cache()

    val algorithm_wealth = new LinearRegressionWithSGD()
    algorithm_wealth.setIntercept(true)
    model_wealth = algorithm_wealth.run(training_wealth)

    if (saveModel) {
      model_health.save(sc, "/home/bas/models/health")
      model_wealth.save(sc, "/home/bas/models/wealth")
    }
  }

  def getHealthPrediction(person: Person) = {
    val v:Vector = new DenseVector(Array(person.familySize.toDouble/10, person.kids.toDouble/10, person.education.toDouble/10))
    model_health.predict(v)
  }

  def getWealthPrediction(person: Person) = {
    val v:Vector = new DenseVector(Array(person.familySize.toDouble/10, person.kids.toDouble/10, person.education.toDouble/10))
    model_wealth.predict(v)
  }

}
