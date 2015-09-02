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

  def getHealthPrediction = {
  }

}
