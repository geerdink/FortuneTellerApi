package models

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.mllib.linalg.{Vector, Vectors}

object AgeDistribution {
  val spConf = new SparkConf().setAppName("Fortune Teller API").setMaster("local[4]")
  var sc = SparkContext.getOrCreate(spConf)

  var fileName = "/home/vagrant/data/age.csv"
  //var file = scala.io.Source.fromFile(fileName)
  var file = sc.textFile(fileName)

  //var lines = file.getLines
  //var par = sc.parallelize(lines.toArray)

  case class WellBeing(minAge: Integer, maxAge: Integer, male:Float, female: Float, total: Float)

  // for (line <- lines) println(line)

  // transformations
  val wb = file
    .map(l => l.split(";"))
    .filter(_(0) != "Age")
    .map(l => WellBeing(
    l(0).split("-")(0).toInt,
    l(0).split("-")(1).toInt,
    l(1).toFloat,
    l(2).toFloat,
    (l(1).toFloat + l(2).toFloat) / 2))


  println(wb.count) + " records found."

  // create vectors
  var vectors = wb.map(x => Vectors.dense(x.minAge.toFloat, x.maxAge.toFloat, x.male, x.female, x.total))

  val summary = Statistics.colStats(vectors)

  println("mean values: " + summary.mean)
  println("variances: " + summary.variance)
}
