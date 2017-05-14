package br.com.supermercado.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Estoque;

public interface EstoqueRepository extends CrudRepository<Estoque, Long> {

}
