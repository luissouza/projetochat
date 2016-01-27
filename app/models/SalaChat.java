package models;

import play.mvc.*;
import play.libs.*;
import play.libs.F.*;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import akka.actor.*;
import static akka.pattern.Patterns.ask;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.*;
import static java.util.concurrent.TimeUnit.*;
import controllers.Conversa;
import controllers.Acesso;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class SalaChat  extends UntypedActor {

	private static ActorSystem system = ActorSystem.create("chat");
	private static ActorRef defaultRoom = system.actorOf(Props.create(SalaChat.class), "chat");
    private static Map<String, WebSocket.Out<JsonNode>> listaDeMembros = new HashMap<String, WebSocket.Out<JsonNode>>();
	
 
    public static void entrarChat(final String username,  WebSocket.In<JsonNode> in, WebSocket.Out<JsonNode> out) throws Exception{
    	final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    	final Date date = new Date();

	Acesso joined = new Acesso(username, out);
	Object obj = (Object)ask(defaultRoom, joined, 1000);
	
	listaDeMembros.put(joined.username, joined.channel);
    
	enviaMensagem(joined.username, "Entrou no Chat. " + " - "  + dateFormat.format(date));
   
	in.onMessage(new Callback<JsonNode>() {
	
	public void invoke(JsonNode event)	 {
		
         Conversa talkInstance = new Conversa(username ,event.get("text").asText() );          
			
			
		 enviaMensagem(username, talkInstance.getMensagem() + " - "  + dateFormat.format(date));
                   
               } 
            });
            
        }
		
	 public static void enviaMensagem(String user, String text) {
      for(WebSocket.Out<JsonNode> lista: listaDeMembros.values()) {
            ObjectNode evento = Json.newObject();
            evento.put("user", user);
            evento.put("message", text);
            lista.write(evento);
       }
    } 
    
    

}
