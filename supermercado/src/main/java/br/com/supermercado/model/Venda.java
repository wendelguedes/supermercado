package br.com.supermercado.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Venda {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional=false)
	private Caixa caixa;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private Date dataVenda;
	
	@Enumerated(EnumType.STRING)
	private EnumTipoPagamento tipoPagamento;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="venda_id")
	private List<ItemVenda> itens = new ArrayList<>();

	@Transient
	private BigDecimal valorPagoDinheiro = BigDecimal.ZERO;

	public BigDecimal valorTotalVenda(){
		BigDecimal totalVenda = BigDecimal.ZERO;
		for (ItemVenda itemVenda : itens) {
			totalVenda = totalVenda.add(itemVenda.getValor());
		}
		return totalVenda;
	}

	public BigDecimal valorTroco(){
		return EnumTipoPagamento.DINHEIRO.equals(this.tipoPagamento) ? 
				valorPagoDinheiro.subtract(this.valorTotalVenda()) : BigDecimal.ZERO;
	}

}
