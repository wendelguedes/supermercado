package br.com.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.supermercado.model.Balanca;
import br.com.supermercado.service.BalancaService;

@Controller
public class BalancaController {

	@Autowired
	private BalancaService balancaService;

	@RequestMapping("/balancas")
	public String listarBalancas(Model model){
		Iterable<Balanca> balancas = balancaService.listarTodos();
		model.addAttribute("balancas", balancas);
		return "balancas";
	}

	@RequestMapping(value= "salvarBalanca", method = RequestMethod.POST)
	public String salvar(Balanca balanca, Model model){

		balancaService.salvar(balanca);

		return listarBalancas(model);
	}

}
