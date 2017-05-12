package br.com.supermercado.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Estoque {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="estoque_id")
	private List<ItemEstoque> itensEstoque = new ArrayList<>();

}
