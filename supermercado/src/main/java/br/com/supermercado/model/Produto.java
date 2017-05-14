package br.com.supermercado.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Produto {

	@Id
	@GeneratedValue(generator="produto_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="produto_seq", sequenceName="produto_seq", allocationSize=1,initialValue=1)
	private Long id;

	private String descricao;
	
	private String codigo;

	@Enumerated(EnumType.STRING)
	private EnumUnidadeMedida unidadeMedida = EnumUnidadeMedida.UN;

	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal preco = BigDecimal.ZERO;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public EnumUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(EnumUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}


}
