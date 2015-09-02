package controllers

import models.SparkEngine.log
import models.SparkEngine
import play.api.libs.json._
import play.api.mvc._

object Admin extends Controller {
  def start = Action { request =>
    SparkEngine.clearLog
    SparkEngine.startServer
    Ok(Json.toJson(log))
  }

  def stop = Action { request =>
    SparkEngine.stopServer
    Ok(Json.toJson(log))
  }

  def getCorrelations = Action { request =>
    Ok(Json.toJson(SparkEngine.getCorrelations))
  }

  def train = Action { request =>
    SparkEngine.train(false)
    Ok(Json.obj("status" -> "OK"))
  }
}
