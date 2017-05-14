package br.com.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.Estoque;
import br.com.supermercado.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	public Iterable<Estoque> listarTodos(){
		return estoqueRepository.findAll();
	}

	public void salvar(Estoque estoque) {
		estoqueRepository.save(estoque);
	}

}
