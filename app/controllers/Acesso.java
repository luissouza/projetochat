package controllers;

import play.mvc.*;
import play.libs.*;
import play.libs.F.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import static java.util.concurrent.TimeUnit.*;

public class Acesso {
        
        public String username;
        public WebSocket.Out<JsonNode> channel;
        
        public Acesso(String username, WebSocket.Out<JsonNode> channel) {
            this.username = username;
            this.channel = channel;
        }
        
}