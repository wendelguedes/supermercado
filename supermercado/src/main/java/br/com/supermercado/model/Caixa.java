package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Caixa {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional=false)
	@JoinColumn(name = "balanca_id")
	private Balanca balanca;

}
