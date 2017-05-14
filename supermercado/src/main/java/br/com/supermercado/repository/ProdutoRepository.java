package br.com.supermercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	List<Produto> findByDescricao(String descricao);
	
	Produto findByCodigo(String codigo);
	
}
