
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object chatRoom extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(username: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""

<html>
        <h1>Usuário logado: """),_display_(Seq[Any](/*4.30*/username)),format.raw/*4.38*/("""</h1>
    
	<div id="onChat">
        <div id="main">
             <div id="messages"></div>
             <textarea id="talk"></textarea>
        </div> 
    </div>
	
	<div>
		<script src=""""),_display_(Seq[Any](/*14.17*/routes/*14.23*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*14.68*/("""" type="text/javascript"></script>
		<script type="text/javascript" charset="utf-8" src=""""),_display_(Seq[Any](/*15.56*/routes/*15.62*/.Chat.chatRoomJs(username))),format.raw/*15.88*/(""""></script>
	</div>
</html>
    """))}
    }
    
    def render(username:String): play.api.templates.HtmlFormat.Appendable = apply(username)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (username) => apply(username)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 07 11:36:01 BRT 2014
                    SOURCE: C:/play-2.2.1/projetochat/app/views/chatRoom.scala.html
                    HASH: 4faf6028751822a9050f6ce61f8e9cf9e09aee64
                    MATRIX: 777->1|889->19|962->57|991->65|1217->255|1232->261|1299->306|1425->396|1440->402|1488->428
                    LINES: 26->1|29->1|32->4|32->4|42->14|42->14|42->14|43->15|43->15|43->15
                    -- GENERATED --
                */
            