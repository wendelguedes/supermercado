package br.com.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.Funcionario;
import br.com.supermercado.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Iterable<Funcionario> listarFuncionarios(String nome){
		return funcionarioRepository.findByNome(nome);
	}


}
