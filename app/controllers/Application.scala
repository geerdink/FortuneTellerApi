package controllers

import models.Survey
import play.api.libs.json._
import play.api.mvc._

object Application extends Controller {

  def addSurvey = Action(BodyParsers.parse.json) { request =>
    val s = request.body.validate[Survey.Survey]
    s.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
      },
      survey => {
        Survey.addSurvey(survey)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }

  def getHealthPrediction = Action(BodyParsers.parse.json) { request =>
    val p = request.body.validate[models.SparkEngine.Person]
    p.fold(
      errors => BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors))),
      person => {
        val prediction = models.SparkEngine.getHealthPrediction(models.SparkEngine.Person(person.familySize, person.kids, person.education))
          //person(0).toString.toInt, person(1).toString.toInt, person(2).toString.toInt))  //person)
        Ok(Json.obj("status" -> "OK", "prediction" -> prediction))
      }
    )
  }

  def getWealthPrediction = Action(BodyParsers.parse.json) { request =>
    val p = request.body.validate[models.SparkEngine.Person]
    p.fold(
      errors => BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors))),
      person => {
        val prediction = models.SparkEngine.getWealthPrediction(models.SparkEngine.Person(person.familySize, person.kids, person.education))
        Ok(Json.obj("status" -> "OK", "prediction" -> prediction))
      }
    )
  }

}
