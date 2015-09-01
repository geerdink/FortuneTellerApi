// @SOURCE:/home/bas/projects/FortuneTellerApi/conf/routes
// @HASH:48ef20b8fe3cedfc458625359fcad15384029472
// @DATE:Wed Sep 02 01:00:06 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:7
// @LINE:6
package controllers {

// @LINE:14
// @LINE:13
class ReverseSparkServer {


// @LINE:14
def stop(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "stop")
}
                        

// @LINE:13
def start(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "start")
}
                        

}
                          

// @LINE:10
class ReverseAssets {


// @LINE:10
def versioned(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:6
def listBooks(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "books")
}
                        

// @LINE:7
def saveBook(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "books")
}
                        

}
                          
}
                  


// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:14
// @LINE:13
class ReverseSparkServer {


// @LINE:14
def stop : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkServer.stop",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stop"})
      }
   """
)
                        

// @LINE:13
def start : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SparkServer.start",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "start"})
      }
   """
)
                        

}
              

// @LINE:10
class ReverseAssets {


// @LINE:10
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:6
def listBooks : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listBooks",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books"})
      }
   """
)
                        

// @LINE:7
def saveBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveBook",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "books"})
      }
   """
)
                        

}
              
}
        


// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:14
// @LINE:13
class ReverseSparkServer {


// @LINE:14
def stop(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkServer.stop(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SparkServer", "stop", Seq(), "GET", """""", _prefix + """stop""")
)
                      

// @LINE:13
def start(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SparkServer.start(), HandlerDef(this.getClass.getClassLoader, "", "controllers.SparkServer", "start", Seq(), "GET", """ Starting and stopping the server""", _prefix + """start""")
)
                      

}
                          

// @LINE:10
class ReverseAssets {


// @LINE:10
def versioned(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:6
def listBooks(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listBooks(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listBooks", Seq(), "GET", """ Home page""", _prefix + """books""")
)
                      

// @LINE:7
def saveBook(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveBook(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveBook", Seq(), "POST", """""", _prefix + """books""")
)
                      

}
                          
}
        
    