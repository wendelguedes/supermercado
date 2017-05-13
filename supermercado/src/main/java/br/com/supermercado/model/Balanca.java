package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Balanca {

	@Id
	@GeneratedValue(generator="balanca_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="balanca_seq", sequenceName="balanca_seq", allocationSize=1,initialValue=1)
	private Long id;

	private String descricao;

	private String marca;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

}
