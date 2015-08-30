package models

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.mllib.linalg.{Vector, Vectors}

import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.util.MLUtils

object AgeDistribution {
  val spConf = new SparkConf().setAppName("Fortune Teller API").setMaster("local[4]")
  var sc = SparkContext.getOrCreate(spConf)
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)
  import sqlContext.implicits._

  var fileName = "/home/vagrant/data/age.csv"
  //var file = scala.io.Source.fromFile(fileName)
  var file = sc.textFile(fileName)

  //var lines = file.getLines
  //var par = sc.parallelize(lines.toArray)

  case class WellBeing(minAge: Integer, maxAge: Integer, male:Float, female: Float, total: Float)

  // for (line <- lines) println(line)

  // transformations
  var wb = file
    .map(_.split(","))
    .filter(_(0) != "Age")
    .map(l => WellBeing(
    l(0).split("-")(0).toInt,
    l(0).split("-")(1).toInt,
    l(1).toFloat,
    l(2).toFloat,
    (l(1).toFloat + l(2).toFloat) / 2))

  var df = wb.toDF()

  println(wb.count) + " records found."

  // create vectors
  var vectors = wb.map(x => Vectors.dense(x.minAge.toFloat, x.maxAge.toFloat, x.male, x.female, x.total))

  val summary = Statistics.colStats(vectors)

  println("mean values: " + summary.mean)
  println("variances: " + summary.variance)

  // CORRELATIONS
  var corr = Statistics.corr(vectors, "pearson")

  println
  println("Correlations:")
  println(corr.toString(10, 1000))

  var vectors_old = wb.filter(_.minAge >= 50).map(x => Vectors.dense(x.minAge.toFloat, x.maxAge.toFloat, x.male, x.female, x.total))
  var corr_old = Statistics.corr(vectors_old, "pearson")

  println
  println("Correlations over 50:")
  println(corr_old.toString(10, 1000))

  var vectors_young = wb.filter(_.minAge < 50).map(x => Vectors.dense(x.minAge.toFloat, x.maxAge.toFloat, x.male, x.female, x.total))
  var corr_young = Statistics.corr(vectors_young, "pearson")

  println
  println("Correlations under 50:")
  println(corr_young.toString(10, 1000))

  // DECISION TREE

  // split data into training and testing?

  val newFile = new java.io.File("wb.csv")
  val pw = new java.io.PrintWriter(newFile)

  var ls = List[String]()
  wb.foreach(l => ls = l.minAge + "," + l.maxAge + ","+ l.female + "," + l.male + "," + l.total :: ls)
  ls.foreach(i => pw.println(i))
  pw.flush()
  pw.close()

  wb.foreach(w => println(w))

  val data = MLUtils.loadLibSVMFile(sc, fileName)

  val categoricalFeaturesInfo = Map[Int, Int]
  val impurity = "variance"
  val maxDepth = 5
  val maxBins = 32

  val data = MLUtils.loadVectors(sc, fileName)

  val model = DecisionTree.trainRegressor() (wb, categoricalFeaturesInfo, impurity, maxDepth, maxBins)


  // LINEAR REGRESSION
  import org.apache.spark.mllib.regression.LabeledPoint
  import org.apache.spark.mllib.regression.LinearRegressionModel
  import org.apache.spark.mllib.regression.LinearRegressionWithSGD
  import org.apache.spark.mllib.linalg.Vectors
  import org.apache.spark.mllib.linalg._

  // split data into two parts: before and after 50. (u-shape of data)
  // nonlinear regression is not part of Spark yet...

  // LabeledPoint: class that represents the features and labels of a data point. LabeledPoint(double label, Vector features)
  val data_young = wb.filter(_.minAge < 50).collect().map(line => LabeledPoint(line.minAge.toFloat, Vectors.dense(line.total)))

  // Building the model
  val numIterations = 100
  val model = LinearRegressionWithSGD.train(sc.makeRDD(data_young), numIterations)

  model.save(sc, "/home/vagrant/models/linearRegressionUnder50")

  // Evaluate model on training examples and compute training error
  val valuesAndPreds = data_young.map { point =>
    val prediction = model.predict(point.features)
    (point.label, prediction)
  }
  val MSE = valuesAndPreds.map{case(v, p) => math.pow((v - p), 2)}

  println("training Mean Squared Error = " + (MSE.sum / MSE.size))

  // make prediction
  val v:Vector = new DenseVector(Array(24.0))
  model.predict(v)
}
