package br.com.supermercado.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.supermercado.model.Estoque;
import br.com.supermercado.model.ItemEstoque;
import br.com.supermercado.service.EstoqueService;

@Controller
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;

	@RequestMapping("/estoque")
	public String listarBalancas(Model model){
		Estoque estoque = new Estoque();
		
		estoque.addItemEstoque(new ItemEstoque(new BigDecimal(100)));
		estoque.addItemEstoque(new ItemEstoque(new BigDecimal(152)));
		estoque.addItemEstoque(new ItemEstoque(new BigDecimal(11)));
		
		System.out.println(estoque.getTotalProdutosEstoque());

		model.addAttribute("estoque", estoque);
		return "estoque";
	}

	@RequestMapping(value= "salvarEstoque", method = RequestMethod.POST)
	public String salvar(@Valid Estoque estoque, Model model){

		estoqueService.salvar(estoque);

		return listarBalancas(model);
	}

}
