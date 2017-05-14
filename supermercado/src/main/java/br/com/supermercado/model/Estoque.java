package br.com.supermercado.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(generator="estoque_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="estoque_seq", sequenceName="estoque_seq", allocationSize=1,initialValue=1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	private BigDecimal totalProdutosEstoque = BigDecimal.ZERO;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="estoque_id")
	private List<ItemEstoque> itensEstoque = new ArrayList<>();

	public void addItemEstoque(ItemEstoque itemEstoque){
		this.itensEstoque.add(itemEstoque);
		this.totalProdutosEstoque = this.totalProdutosEstoque.add(itemEstoque.getQuantidade());
	}

	public void removerItemEstoque(ItemEstoque itemEstoque){
		this.itensEstoque.remove(itemEstoque);
		this.totalProdutosEstoque = this.totalProdutosEstoque.subtract(itemEstoque.getQuantidade());
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getTotalProdutosEstoque() {
		return totalProdutosEstoque;
	}

	public void setTotalProdutosEstoque(BigDecimal totalProdutosEstoque) {
		this.totalProdutosEstoque = totalProdutosEstoque;
	}

	public Long getId() {
		return id;
	}

	public List<ItemEstoque> getItensEstoque() {
		return itensEstoque;
	}

}
