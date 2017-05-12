package br.com.supermercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supermercado.model.Produto;
import br.com.supermercado.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Iterable<Produto> listarTodos(){
		return produtoRepository.findAll();
	}

	public void salvar(Produto produto) {
		produtoRepository.save(produto);
	}

}
