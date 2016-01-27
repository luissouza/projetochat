// @SOURCE:C:/play-2.2.1/projetochat/conf/routes
// @HASH:62097f6ec9348671d662bb3a8fc81b9de1d406e5
// @DATE:Wed Oct 01 14:13:46 BRT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:4
private[this] lazy val controllers_Chat_login0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:5
private[this] lazy val controllers_Chat_inicializaChat1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("room/inicializachat"))))
        

// @LINE:6
private[this] lazy val controllers_Chat_chatRoomJs2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/chatroom.js"))))
        

// @LINE:7
private[this] lazy val controllers_Chat_consultar3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consultalogin"))))
        

// @LINE:11
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Chat.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """room/inicializachat""","""controllers.Chat.inicializaChat(username:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/chatroom.js""","""controllers.Chat.chatRoomJs(username:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consultalogin""","""controllers.Chat.consultar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:4
case controllers_Chat_login0(params) => {
   call { 
        invokeHandler(controllers.Chat.login(), HandlerDef(this, "controllers.Chat", "login", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:5
case controllers_Chat_inicializaChat1(params) => {
   call(params.fromQuery[String]("username", None)) { (username) =>
        invokeHandler(controllers.Chat.inicializaChat(username), HandlerDef(this, "controllers.Chat", "inicializaChat", Seq(classOf[String]),"GET", """""", Routes.prefix + """room/inicializachat"""))
   }
}
        

// @LINE:6
case controllers_Chat_chatRoomJs2(params) => {
   call(params.fromQuery[String]("username", None)) { (username) =>
        invokeHandler(controllers.Chat.chatRoomJs(username), HandlerDef(this, "controllers.Chat", "chatRoomJs", Seq(classOf[String]),"GET", """""", Routes.prefix + """assets/javascripts/chatroom.js"""))
   }
}
        

// @LINE:7
case controllers_Chat_consultar3(params) => {
   call { 
        invokeHandler(controllers.Chat.consultar(), HandlerDef(this, "controllers.Chat", "consultar", Nil,"POST", """""", Routes.prefix + """consultalogin"""))
   }
}
        

// @LINE:11
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     