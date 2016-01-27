package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
@Table(name = "login")
public class Login extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "senha")
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static Model.Finder<Long, Login> find = new Model.Finder<Long, Login>(Long.class, Login.class);

}