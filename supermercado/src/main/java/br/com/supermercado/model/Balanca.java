package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Balanca {

	@Id
	@GeneratedValue
	private Long id;

}
