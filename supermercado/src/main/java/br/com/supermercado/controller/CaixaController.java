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
import br.com.supermercado.model.Caixa;
import br.com.supermercado.service.BalancaService;
import br.com.supermercado.service.CaixaService;

@Controller
public class CaixaController {

	@Autowired
	private CaixaService caixaService;

	@Autowired
	private BalancaService balancaService;

	@RequestMapping("/caixas")
	public String listarBalancas(Model model){

		Iterable<Caixa> caixas = caixaService.listarTodos();
		model.addAttribute("caixas", caixas);

		Iterable<Balanca> balancas = balancaService.listarTodos();
		model.addAttribute("balancas", balancas);

		return "caixas";
	}

	@RequestMapping(value= "salvarCaixa", method = RequestMethod.POST)
	public String salvar(@Valid Caixa caixa, BindingResult result,  RedirectAttributes redirectAttributes, Model model){

		caixaService.salvar(caixa);
		
		if(result.hasErrors()){
			return listarBalancas(model);
		}

		return listarBalancas(model);


	}




}
