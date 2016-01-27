@(username: String)

$(function() {

	var websocket = new WebSocket("@routes.Chat.inicializaChat(username).webSocketURL(request)")

    var enviaMensagem = function() {
        websocket.send(JSON.stringify(
            {text: $("#talk").val()}
        ))
        $("#talk").val('')
    }
	
	
	
	 function enviaMensagemEnter(e) {
       e.which = e.which || e.keyCode;
      if(e.which == 13) {
          enviaMensagem()
      }
    }

    var receiveEvent = function(event) {
        var dadosConversa = JSON.parse(event.data)
		
		
		
         $("#onChat").show()
		 
        var el = $('<div class="message"><span></span><p></p></div>')
        $("span", el).text(dadosConversa.user)
		
        $("p", el).text(dadosConversa.message)
        $(el).addClass(dadosConversa.kind)
        if(dadosConversa.user == '@username') $(el).addClass('me')
        $('#messages').append(el)
	
	}

   $("#talk").keypress(enviaMensagemEnter)
    websocket.onmessage = receiveEvent
})
