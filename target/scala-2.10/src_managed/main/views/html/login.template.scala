
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(loginForm : Form[models.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""
	
<div>
	<div>
		"""),_display_(Seq[Any](/*5.4*/helper/*5.10*/.form(action=routes.Chat.consultar())/*5.47*/ {_display_(Seq[Any](format.raw/*5.49*/("""
		<form>
			<fieldset>
				<legend>Login</legend>
				<div>
					<div>
					    
						"""),_display_(Seq[Any](/*12.8*/helper/*12.14*/.inputText(loginForm("name"), '_label -> "Nome: "))),format.raw/*12.64*/("""
						"""),_display_(Seq[Any](/*13.8*/helper/*13.14*/.inputPassword(loginForm("senha"), '_label -> "Senha: "))),format.raw/*13.70*/("""
						
					</div>
				</div>
				""")))})),format.raw/*17.6*/("""

				<div>
					<label for="singlebutton"></label>
					
					<div>
				    <button id="singlebutton" name="singlebutton">Entrar</button>
					</div>
				</div>
		</form>
	</div>
</div>"""))}
    }
    
    def render(loginForm:Form[models.Login]): play.api.templates.HtmlFormat.Appendable = apply(loginForm)
    
    def f:((Form[models.Login]) => play.api.templates.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Sep 24 09:49:56 BRT 2014
                    SOURCE: C:/play-2.2.1/projetochat/app/views/login.scala.html
                    HASH: 454a773aab1a9b2b341fc3dd70343eb5066c95f6
                    MATRIX: 786->1|912->33|969->56|983->62|1028->99|1067->101|1198->197|1213->203|1285->253|1329->262|1344->268|1422->324|1493->364
                    LINES: 26->1|29->1|33->5|33->5|33->5|33->5|40->12|40->12|40->12|41->13|41->13|41->13|45->17
                    -- GENERATED --
                */
            