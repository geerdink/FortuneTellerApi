package models

import org.apache.spark.mllib.linalg.Vectors
import play.api.libs.json.Json

object Survey {
  case class Survey(FamilySize: Double, Kids: Double, Education: Double, // family size, kids, education
                  Health: Double,  // health: number of family members whose health is very good or excellent, divided by number of family members.
                  Wealth: Double)  // wealth = ratio of family income to the poverty treshold (RAT_CAT2). skip: 15,16,17,96,99

  implicit val writes = Json.writes[Survey]
  implicit val reads = Json.reads[Survey]

  val fileName = "/home/bas/Data/nhisfamily.csv"
  val file = SparkEngine.sc.textFile(fileName)

  var surveys = file
    .map(l => l.split(",")) // comma-separated file
    .filter(_(0) != "RECTYPE") // skip header
    .filter(_(121).toInt < 15) // skip records with undefinable, unknown or unclear poverty ratios
    .filter(_(22).toInt < 10) // skip people with undefinable, unknown or unclear education
    .filter(_(16).toInt < 11) // skip families with more than 10 people
    .filter(_(17).toInt < 11) // skip families with more than 10 kids
    .map(l => Survey(l(16).toDouble, l(17).toDouble, l(22).toDouble,
    (l(40).toDouble + l(39).toDouble) / l(16).toInt,
    l(121).toDouble))

  var vectors = surveys.map(x => Vectors.dense(x.FamilySize, x.Kids, x.Education, x.Health, x.Wealth))

  def addSurvey(s: Survey) = surveys = surveys // ::: List(s)

}
