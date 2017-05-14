package br.com.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.Venda;
import br.com.supermercado.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public Iterable<Venda> listarTodos(){
		return vendaRepository.findAll();
	}

	public void salvar(Venda venda) {
		vendaRepository.save(venda);
	}

}
