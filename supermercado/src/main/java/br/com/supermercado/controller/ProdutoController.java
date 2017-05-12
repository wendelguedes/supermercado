package br.com.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.supermercado.model.Produto;
import br.com.supermercado.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping("/produtos")
	public String listarProdutos(Model model){
		Iterable<Produto> produtos = produtoService.listarTodos();
		model.addAttribute("produtos", produtos);
		return "produtos";
	}

	@RequestMapping(value= "salvarProduto", method = RequestMethod.POST)
	public String salvar(Produto produto, Model model){

		produtoService.salvar(produto);

		//		Iterable<Produto> convidados = produtoService.listarTodos();
		//		model.addAttribute("convidados", convidados);
		//
		//		return "convidados";
		return listarProdutos(model);
	}

}
