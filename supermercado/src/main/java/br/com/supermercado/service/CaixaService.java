package br.com.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.Caixa;
import br.com.supermercado.repository.CaixaRepository;

@Service
public class CaixaService {

	@Autowired
	private CaixaRepository caixaRepository;

	public Iterable<Caixa> listarTodos(){
		return caixaRepository.findAll();
	}

	public void salvar(Caixa caixa) {
		caixaRepository.save(caixa);
	}

}
