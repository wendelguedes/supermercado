package br.com.supermercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.supermercado.model.ItemEstoque;
import br.com.supermercado.model.Produto;

public interface ItemEstoqueRepository extends CrudRepository<ItemEstoque, Long> {

	ItemEstoque findByProduto(Produto produto);

}
