package br.com.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.supermercado.model.Balanca;
import br.com.supermercado.repository.BalancaRepository;


@Component
public class StringToBalanca implements Converter<String, Balanca> {

	@Autowired
	private BalancaRepository repository;

	@Override
	public Balanca convert(String arg0) {
		Long id = new Long(arg0);
		return repository.findOne(id);
	}

}