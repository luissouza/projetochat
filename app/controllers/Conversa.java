package controllers;

public class Conversa {
        
    public String usuario;
    public String mensagem;
        
    public Conversa(String usuario, String mensagem) {
	    this.usuario = usuario;
        this.mensagem =  mensagem;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
        
}