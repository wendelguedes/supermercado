package br.com.supermercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.ItemVenda;

public interface ItemVendaRepository extends CrudRepository<ItemVenda, Long> {


}
