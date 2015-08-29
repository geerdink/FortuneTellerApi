package controllers

import play.api.libs.json._
import play.api.mvc._
import models.SparkServer._

object SparkServer extends Controller {
  def start = Action { request =>
    clearLog
    startServer
    Ok(log)
  }

  def stop = Action { request =>
    stopServer
    Ok(log)
  }
}