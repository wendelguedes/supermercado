package br.com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Gerente extends Funcionario {
	
	@Id
	@GeneratedValue(generator="gerente_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="gerente_seq", sequenceName="gerente_seq", allocationSize=1,initialValue=1)
	private Long id;
	
	private String area;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getId() {
		return id;
	}

}