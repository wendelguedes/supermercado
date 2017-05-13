package br.com.supermercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Caixa;

public interface CaixaRepository extends CrudRepository<Caixa, Long> {

	List<Caixa> findByDescricao(String descricao);

}
