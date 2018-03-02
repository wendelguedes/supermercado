package br.com.supermercado.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemEstoque {

	@Id
	@GeneratedValue(generator="item_estoque_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_estoque_seq", sequenceName="item_estoque_seq", allocationSize=1,initialValue=1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	private BigDecimal quantidade;

	//@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@JoinColumn(name="item_estoque_id")
	//private List<SubItemEstoque> subItensEstoque = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}


}
