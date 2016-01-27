package controllers;

import play.api.Logger.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import views.html.*;
import models.*;
import play.api.data.Form.*;
import play.data.Form;
import views.html.helper.form;
import views.html.*;

public class Chat extends Controller {

	
	private static final Form<Login> loginForm = Form.form(Login.class);
	
	public static Result login() {


		return ok(login.render(loginForm));
	}

	public static Result abreSalaChat(String username) {
		return ok(chatRoom.render(username));

	}
	
	public static Result consultar() {
		Form<Login> form = loginForm.bindFromRequest();
		Login log = form.get();
		Login newLogin = new Login();
		
		if (!log.getName().equals(null) && !log.getSenha().equals(null)) {
			newLogin = Login.find.where().eq("name", log.getName())
					.eq("senha", log.getSenha()).findUnique();
		} 

		if (log.getName().equals(newLogin.getName())
				&& log.getSenha().equals(newLogin.getSenha())) {

			return Chat.abreSalaChat(log.getName());

		} else {

			return Chat.login();
		}
	
	}

	public static Result chatRoomJs(String username) {
		return ok(views.js.chatRoom.render(username));

	}

	public static WebSocket<JsonNode> inicializaChat(final String username) {
		
		return new WebSocket<JsonNode>() {

			public void onReady(WebSocket.In<JsonNode> in,
					WebSocket.Out<JsonNode> out) {

				try {
					ChatRoom.entrarChat(username, in, out);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
	}
}
