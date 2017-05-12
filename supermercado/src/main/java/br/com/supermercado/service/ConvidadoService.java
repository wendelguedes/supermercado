package br.com.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.Convidado;
import br.com.supermercado.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;

	public Iterable<Convidado> listarTodos(){
		return repository.findAll();
	}

	public void salvar(Convidado novoConvidado) {
		repository.save(novoConvidado);
	}

}
