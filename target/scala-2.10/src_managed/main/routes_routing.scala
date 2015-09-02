// @SOURCE:/home/bas/projects/FortuneTellerApi/conf/routes
// @HASH:f8e590b4d18216989fc324f242fd7aed002cd2d6
// @DATE:Wed Sep 02 23:09:14 CEST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Admin_start0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("start"))))
private[this] lazy val controllers_Admin_start0_invoker = createInvoker(
controllers.Admin.start,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "start", Nil,"GET", """ Starting and stopping the server""", Routes.prefix + """start"""))
        

// @LINE:7
private[this] lazy val controllers_Admin_stop1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stop"))))
private[this] lazy val controllers_Admin_stop1_invoker = createInvoker(
controllers.Admin.stop,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "stop", Nil,"GET", """""", Routes.prefix + """stop"""))
        

// @LINE:10
private[this] lazy val controllers_Admin_getCorrelations2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("correlations"))))
private[this] lazy val controllers_Admin_getCorrelations2_invoker = createInvoker(
controllers.Admin.getCorrelations,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "getCorrelations", Nil,"GET", """ Machine learning""", Routes.prefix + """correlations"""))
        

// @LINE:11
private[this] lazy val controllers_Admin_train3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("train"))))
private[this] lazy val controllers_Admin_train3_invoker = createInvoker(
controllers.Admin.train,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "train", Nil,"GET", """""", Routes.prefix + """train"""))
        

// @LINE:14
private[this] lazy val controllers_Application_addSurvey4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("survey"))))
private[this] lazy val controllers_Application_addSurvey4_invoker = createInvoker(
controllers.Application.addSurvey,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addSurvey", Nil,"POST", """ Add data""", Routes.prefix + """survey"""))
        

// @LINE:17
private[this] lazy val controllers_Application_getHealthPrediction5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("prediction/health"))))
private[this] lazy val controllers_Application_getHealthPrediction5_invoker = createInvoker(
controllers.Application.getHealthPrediction,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getHealthPrediction", Nil,"GET", """ Predictions""", Routes.prefix + """prediction/health"""))
        

// @LINE:18
private[this] lazy val controllers_Application_getWealthPrediction6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("prediction/wealth"))))
private[this] lazy val controllers_Application_getWealthPrediction6_invoker = createInvoker(
controllers.Application.getWealthPrediction,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getWealthPrediction", Nil,"GET", """""", Routes.prefix + """prediction/wealth"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """start""","""controllers.Admin.start"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stop""","""controllers.Admin.stop"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """correlations""","""controllers.Admin.getCorrelations"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """train""","""controllers.Admin.train"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """survey""","""controllers.Application.addSurvey"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """prediction/health""","""controllers.Application.getHealthPrediction"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """prediction/wealth""","""controllers.Application.getWealthPrediction""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Admin_start0_route(params) => {
   call { 
        controllers_Admin_start0_invoker.call(controllers.Admin.start)
   }
}
        

// @LINE:7
case controllers_Admin_stop1_route(params) => {
   call { 
        controllers_Admin_stop1_invoker.call(controllers.Admin.stop)
   }
}
        

// @LINE:10
case controllers_Admin_getCorrelations2_route(params) => {
   call { 
        controllers_Admin_getCorrelations2_invoker.call(controllers.Admin.getCorrelations)
   }
}
        

// @LINE:11
case controllers_Admin_train3_route(params) => {
   call { 
        controllers_Admin_train3_invoker.call(controllers.Admin.train)
   }
}
        

// @LINE:14
case controllers_Application_addSurvey4_route(params) => {
   call { 
        controllers_Application_addSurvey4_invoker.call(controllers.Application.addSurvey)
   }
}
        

// @LINE:17
case controllers_Application_getHealthPrediction5_route(params) => {
   call { 
        controllers_Application_getHealthPrediction5_invoker.call(controllers.Application.getHealthPrediction)
   }
}
        

// @LINE:18
case controllers_Application_getWealthPrediction6_route(params) => {
   call { 
        controllers_Application_getWealthPrediction6_invoker.call(controllers.Application.getWealthPrediction)
   }
}
        
}

}
     