package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(generator="pessoa_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="pessoa_seq", sequenceName="pessoa_seq", allocationSize=1,initialValue=1)
	private Long id;

	private String nome;

}
