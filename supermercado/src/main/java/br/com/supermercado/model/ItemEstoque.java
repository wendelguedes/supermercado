package br.com.supermercado.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ItemEstoque {

	@Id
	@GeneratedValue(generator="item_estoque_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_estoque_seq", sequenceName="item_estoque_seq", allocationSize=1,initialValue=1)
	private Long id;

	private BigDecimal quantidade = BigDecimal.ZERO;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrada = new Date();

	public ItemEstoque() {}

	public ItemEstoque(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
}
