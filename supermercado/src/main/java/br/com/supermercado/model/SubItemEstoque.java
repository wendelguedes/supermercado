package br.com.supermercado.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubItemEstoque {

	@Id
	@GeneratedValue
	private Long id;

	private BigDecimal quantidade;

	private Date data;

	@ManyToOne(optional=false)
	@JoinColumn(name = "gerente_id")
	private Gerente gerente;

}
