package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Funcionario extends Pessoa {
	
	@Id
	@GeneratedValue(generator="funcionario_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="funcionario_seq", sequenceName="funcionario_seq", allocationSize=1,initialValue=1)
	private Long id;
	
	private String login;
	
	private String senha;
	
	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
