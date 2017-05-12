package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario extends Pessoa {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String login;
	
	private String senha;

}
