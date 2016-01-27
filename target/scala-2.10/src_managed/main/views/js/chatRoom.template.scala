
package views.js

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
import views.js._
/**/
object chatRoom extends BaseScalaTemplate[play.api.templates.JavaScriptFormat.Appendable,Format[play.api.templates.JavaScriptFormat.Appendable]](play.api.templates.JavaScriptFormat) with play.api.templates.Template1[String,play.api.templates.JavaScriptFormat.Appendable] {

    /**/
    def apply/*1.2*/(username: String):play.api.templates.JavaScriptFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""

$(function() """),format.raw/*3.14*/("""{"""),format.raw/*3.15*/("""

	var websocket = new WebSocket(""""),_display_(Seq[Any](/*5.34*/routes/*5.40*/.Chat.inicializaChat(username).webSocketURL(request))),format.raw/*5.92*/("""")

    var enviaMensagem = function() """),format.raw/*7.36*/("""{"""),format.raw/*7.37*/("""
        websocket.send(JSON.stringify(
            """),format.raw/*9.13*/("""{"""),format.raw/*9.14*/("""text: $("#talk").val()"""),format.raw/*9.36*/("""}"""),format.raw/*9.37*/("""
        ))
        $("#talk").val('')
    """),format.raw/*12.5*/("""}"""),format.raw/*12.6*/("""
	
	
	
	 function enviaMensagemEnter(e) """),format.raw/*16.34*/("""{"""),format.raw/*16.35*/("""
       e.which = e.which || e.keyCode;
      if(e.which == 13) """),format.raw/*18.25*/("""{"""),format.raw/*18.26*/("""
          enviaMensagem()
      """),format.raw/*20.7*/("""}"""),format.raw/*20.8*/("""
    """),format.raw/*21.5*/("""}"""),format.raw/*21.6*/("""

    var receiveEvent = function(event) """),format.raw/*23.40*/("""{"""),format.raw/*23.41*/("""
        var dadosConversa = JSON.parse(event.data)
		
		
		
         $("#onChat").show()
		 
        var el = $('<div class="message"><span></span><p></p></div>')
        $("span", el).text(dadosConversa.user)
		
        $("p", el).text(dadosConversa.message)
        $(el).addClass(dadosConversa.kind)
        if(dadosConversa.user == '"""),_display_(Seq[Any](/*35.36*/username)),format.raw/*35.44*/("""') $(el).addClass('me')
        $('#messages').append(el)
	
	"""),format.raw/*38.2*/("""}"""),format.raw/*38.3*/("""

   $("#talk").keypress(enviaMensagemEnter)
    websocket.onmessage = receiveEvent
"""),format.raw/*42.1*/("""}"""),format.raw/*42.2*/(""")
"""))}
    }
    
    def render(username:String): play.api.templates.JavaScriptFormat.Appendable = apply(username)
    
    def f:((String) => play.api.templates.JavaScriptFormat.Appendable) = (username) => apply(username)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 07 10:58:37 BRT 2014
                    SOURCE: C:/play-2.2.1/projetochat/app/views/chatRoom.scala.js
                    HASH: 5111e100b73a759447da7b27585b54f9ad84dfa4
                    MATRIX: 797->1|915->19|957->34|985->35|1055->70|1069->76|1142->128|1208->167|1236->168|1315->220|1343->221|1392->243|1420->244|1490->287|1518->288|1586->328|1615->329|1707->393|1736->394|1796->427|1824->428|1856->433|1884->434|1953->475|1982->476|2357->815|2387->823|2475->884|2503->885|2614->969|2642->970
                    LINES: 26->1|29->1|31->3|31->3|33->5|33->5|33->5|35->7|35->7|37->9|37->9|37->9|37->9|40->12|40->12|44->16|44->16|46->18|46->18|48->20|48->20|49->21|49->21|51->23|51->23|63->35|63->35|66->38|66->38|70->42|70->42
                    -- GENERATED --
                */
            