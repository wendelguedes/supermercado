package br.com.supermercado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.supermercado.model.Estoque;
import br.com.supermercado.model.Produto;
import br.com.supermercado.service.EstoqueService;
import br.com.supermercado.service.ProdutoService;

@Controller
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping("/estoque")
	public String listarEstoque(Model model){
		Iterable<Produto> produtos = produtoService.listarTodos();
		model.addAttribute("produtos", produtos);
		
		Iterable<Estoque> estoques = estoqueService.listarTodos();
		model.addAttribute("estoques", estoques);
		
		model.addAttribute("estoque", new Estoque());

		return "estoque";
	}

	@RequestMapping(value= "salvarEstoque", method = RequestMethod.POST)
	public String salvar(@Valid Estoque estoque, BindingResult result, RedirectAttributes redirectAttributes, Model model){
				
		estoqueService.salvar(estoque);
		
		if(result.hasErrors()){
			return listarEstoque(model);
		}

		return listarEstoque(model);
	}

}
