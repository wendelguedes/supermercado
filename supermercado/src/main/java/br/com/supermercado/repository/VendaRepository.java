package br.com.supermercado.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Venda;

public interface VendaRepository extends CrudRepository<Venda, Long> {

}

