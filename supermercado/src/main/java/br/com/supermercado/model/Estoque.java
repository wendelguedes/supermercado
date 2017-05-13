package br.com.supermercado.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(generator="estoque_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="estoque_seq", sequenceName="estoque_seq", allocationSize=1,initialValue=1)
	private Long id;

	private String descricao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="estoque_id")
	private List<ItemEstoque> itensEstoque = new ArrayList<>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ItemEstoque> getItensEstoque() {
		return itensEstoque;
	}

	public void setItensEstoque(List<ItemEstoque> itensEstoque) {
		this.itensEstoque = itensEstoque;
	}

	public Long getId() {
		return id;
	}

}
