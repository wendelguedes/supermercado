package br.com.supermercado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("balanca", new Balanca());
		
		return "balancas";
	}
	
	@RequestMapping(value= "salvarBalanca", method = RequestMethod.POST)
	public String salvar(@Valid Balanca balanca, BindingResult result,  RedirectAttributes redirectAttributes, Model model){

		balancaService.salvar(balanca);
		
		if(result.hasErrors()){
			return listarBalancas(model);
		}

		return listarBalancas(model);
	}

}
