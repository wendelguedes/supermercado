package br.com.supermercado.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private EnumUnidadeMedida unidadeMedida = EnumUnidadeMedida.UN;

	private BigDecimal preco = BigDecimal.ZERO;

}
