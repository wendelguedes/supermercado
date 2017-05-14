package br.com.supermercado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.supermercado.model.Venda;
import br.com.supermercado.service.VendaService;

@Controller
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@RequestMapping("/venda")
	public String listarBalancas(Model model){
		Venda venda = new Venda();
		model.addAttribute("venda", venda);
		return "venda";
	}

	@RequestMapping(value= "salvarVenda", method = RequestMethod.POST)
	public String salvar(@Valid Venda venda, Model model){

		vendaService.salvar(venda);

		return listarBalancas(model);
	}

}
