// @SOURCE:/home/bas/projects/FortuneTellerApi/conf/routes
// @HASH:f8e590b4d18216989fc324f242fd7aed002cd2d6
// @DATE:Wed Sep 02 23:09:14 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
class ReverseAdmin {


// @LINE:10
def getCorrelations(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "correlations")
}
                        

// @LINE:11
def train(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "train")
}
                        

// @LINE:7
def stop(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "stop")
}
                        

// @LINE:6
def start(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "start")
}
                        

}
                          

// @LINE:18
// @LINE:17
// @LINE:14
class ReverseApplication {


// @LINE:14
def addSurvey(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "survey")
}
                        

// @LINE:18
def getWealthPrediction(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "prediction/wealth")
}
                        

// @LINE:17
def getHealthPrediction(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "prediction/health")
}
                        

}
                          
}
                  


// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
class ReverseAdmin {


// @LINE:10
def getCorrelations : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.getCorrelations",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "correlations"})
      }
   """
)
                        

// @LINE:11
def train : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.train",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "train"})
      }
   """
)
                        

// @LINE:7
def stop : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.stop",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stop"})
      }
   """
)
                        

// @LINE:6
def start : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.start",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "start"})
      }
   """
)
                        

}
              

// @LINE:18
// @LINE:17
// @LINE:14
class ReverseApplication {


// @LINE:14
def addSurvey : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addSurvey",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "survey"})
      }
   """
)
                        

// @LINE:18
def getWealthPrediction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getWealthPrediction",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prediction/wealth"})
      }
   """
)
                        

// @LINE:17
def getHealthPrediction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getHealthPrediction",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "prediction/health"})
      }
   """
)
                        

}
              
}
        


// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
// @LINE:10
// @LINE:7
// @LINE:6
class ReverseAdmin {


// @LINE:10
def getCorrelations(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.getCorrelations(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "getCorrelations", Seq(), "GET", """ Machine learning""", _prefix + """correlations""")
)
                      

// @LINE:11
def train(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.train(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "train", Seq(), "GET", """""", _prefix + """train""")
)
                      

// @LINE:7
def stop(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.stop(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "stop", Seq(), "GET", """""", _prefix + """stop""")
)
                      

// @LINE:6
def start(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.start(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "start", Seq(), "GET", """ Starting and stopping the server""", _prefix + """start""")
)
                      

}
                          

// @LINE:18
// @LINE:17
// @LINE:14
class ReverseApplication {


// @LINE:14
def addSurvey(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addSurvey(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addSurvey", Seq(), "POST", """ Add data""", _prefix + """survey""")
)
                      

// @LINE:18
def getWealthPrediction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getWealthPrediction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getWealthPrediction", Seq(), "GET", """""", _prefix + """prediction/wealth""")
)
                      

// @LINE:17
def getHealthPrediction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getHealthPrediction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getHealthPrediction", Seq(), "GET", """ Predictions""", _prefix + """prediction/health""")
)
                      

}
                          
}
        
    