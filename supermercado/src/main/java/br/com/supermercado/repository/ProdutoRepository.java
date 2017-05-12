package br.com.supermercado.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {


}
