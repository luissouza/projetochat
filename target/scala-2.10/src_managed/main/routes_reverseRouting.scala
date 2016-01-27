// @SOURCE:C:/play-2.2.1/projetochat/conf/routes
// @HASH:62097f6ec9348671d662bb3a8fc81b9de1d406e5
// @DATE:Wed Oct 01 14:13:46 BRT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:11
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package controllers {

// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
class ReverseChat {
    

// @LINE:6
def chatRoomJs(username:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/chatroom.js" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("username", username)))))
}
                                                

// @LINE:5
def inicializaChat(username:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "room/inicializachat" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("username", username)))))
}
                                                

// @LINE:7
def consultar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consultalogin")
}
                                                

// @LINE:4
def login(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:11
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package controllers.javascript {

// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
class ReverseChat {
    

// @LINE:6
def chatRoomJs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Chat.chatRoomJs",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/chatroom.js" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("username", username)])})
      }
   """
)
                        

// @LINE:5
def inicializaChat : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Chat.inicializaChat",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "room/inicializachat" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("username", username)])})
      }
   """
)
                        

// @LINE:7
def consultar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Chat.consultar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consultalogin"})
      }
   """
)
                        

// @LINE:4
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Chat.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:11
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package controllers.ref {


// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
class ReverseChat {
    

// @LINE:6
def chatRoomJs(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Chat.chatRoomJs(username), HandlerDef(this, "controllers.Chat", "chatRoomJs", Seq(classOf[String]), "GET", """""", _prefix + """assets/javascripts/chatroom.js""")
)
                      

// @LINE:5
def inicializaChat(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Chat.inicializaChat(username), HandlerDef(this, "controllers.Chat", "inicializaChat", Seq(classOf[String]), "GET", """""", _prefix + """room/inicializachat""")
)
                      

// @LINE:7
def consultar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Chat.consultar(), HandlerDef(this, "controllers.Chat", "consultar", Seq(), "POST", """""", _prefix + """consultalogin""")
)
                      

// @LINE:4
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Chat.login(), HandlerDef(this, "controllers.Chat", "login", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        
    