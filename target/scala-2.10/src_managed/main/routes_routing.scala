// @SOURCE:/home/bas/projects/FortuneTellerApi/conf/routes
// @HASH:48ef20b8fe3cedfc458625359fcad15384029472
// @DATE:Wed Sep 02 01:00:06 CEST 2015


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
private[this] lazy val controllers_Application_listBooks0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("books"))))
private[this] lazy val controllers_Application_listBooks0_invoker = createInvoker(
controllers.Application.listBooks,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listBooks", Nil,"GET", """ Home page""", Routes.prefix + """books"""))
        

// @LINE:7
private[this] lazy val controllers_Application_saveBook1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("books"))))
private[this] lazy val controllers_Application_saveBook1_invoker = createInvoker(
controllers.Application.saveBook,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveBook", Nil,"POST", """""", Routes.prefix + """books"""))
        

// @LINE:10
private[this] lazy val controllers_Assets_versioned2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:13
private[this] lazy val controllers_SparkServer_start3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("start"))))
private[this] lazy val controllers_SparkServer_start3_invoker = createInvoker(
controllers.Admin.start,
HandlerDef(this.getClass.getClassLoader, "", "controllers.SparkServer", "start", Nil,"GET", """ Starting and stopping the server""", Routes.prefix + """start"""))
        

// @LINE:14
private[this] lazy val controllers_SparkServer_stop4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stop"))))
private[this] lazy val controllers_SparkServer_stop4_invoker = createInvoker(
controllers.Admin.stop,
HandlerDef(this.getClass.getClassLoader, "", "controllers.SparkServer", "stop", Nil,"GET", """""", Routes.prefix + """stop"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """books""","""controllers.Application.listBooks"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """books""","""controllers.Application.saveBook"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """start""","""controllers.SparkServer.start"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stop""","""controllers.SparkServer.stop""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_listBooks0_route(params) => {
   call { 
        controllers_Application_listBooks0_invoker.call(controllers.Application.listBooks)
   }
}
        

// @LINE:7
case controllers_Application_saveBook1_route(params) => {
   call { 
        controllers_Application_saveBook1_invoker.call(controllers.Application.saveBook)
   }
}
        

// @LINE:10
case controllers_Assets_versioned2_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        

// @LINE:13
case controllers_SparkServer_start3_route(params) => {
   call { 
        controllers_SparkServer_start3_invoker.call(controllers.Admin.start)
   }
}
        

// @LINE:14
case controllers_SparkServer_stop4_route(params) => {
   call { 
        controllers_SparkServer_stop4_invoker.call(controllers.Admin.stop)
   }
}
        
}

}
     