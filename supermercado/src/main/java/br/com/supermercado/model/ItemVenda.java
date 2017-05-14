package br.com.supermercado.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ItemVenda {

	@Id
	@GeneratedValue(generator="item_venda_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_venda_seq", sequenceName="item_venda_seq", allocationSize=1,initialValue=1)
	private Long id;

	@ManyToOne(optional=false)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	private BigDecimal valor = BigDecimal.ZERO;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar data;

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
