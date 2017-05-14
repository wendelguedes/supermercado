package br.com.supermercado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("produto", new Produto());

		return "produtos";
	}

	@RequestMapping(value= "salvarProduto", method = RequestMethod.POST)
	public String salvar(@Valid  Produto produto, BindingResult result, RedirectAttributes redirectAttributes, Model model){

		produtoService.salvar(produto);

		if(result.hasErrors()){
			return listarProdutos(model);
		}

		return listarProdutos(model);
	}

}
