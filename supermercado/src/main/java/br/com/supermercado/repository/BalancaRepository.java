package br.com.supermercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Balanca;

public interface BalancaRepository extends CrudRepository<Balanca, Long> {

	List<Balanca> findByDescricao(String descricao);

}
