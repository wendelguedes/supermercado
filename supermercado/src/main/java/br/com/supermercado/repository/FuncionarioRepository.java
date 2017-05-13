package br.com.supermercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	List<Funcionario> findByNome(String nome);

}
