package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Caixa {

	@Id
	@GeneratedValue(generator="caixa_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="caixa_seq", sequenceName="caixa_seq", allocationSize=1,initialValue=1)
	private Long id;
	
	private String descricao;

	@ManyToOne(optional=false)
	@JoinColumn(name = "balanca_id")
	private Balanca balanca;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Balanca getBalanca() {
		return balanca;
	}

	public void setBalanca(Balanca balanca) {
		this.balanca = balanca;
	}

	public Long getId() {
		return id;
	}

}
