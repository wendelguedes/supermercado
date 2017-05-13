package br.com.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.Balanca;
import br.com.supermercado.repository.BalancaRepository;

@Service
public class BalancaService {

	@Autowired
	private BalancaRepository balancaRepository;

	public Iterable<Balanca> listarTodos(){
		return balancaRepository.findAll();
	}

	public void salvar(Balanca balanca) {
		balancaRepository.save(balanca);
	}

}
