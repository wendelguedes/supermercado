package br.com.supermercado.controller;

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
	public String listarVendas(Model model){
		Iterable<Venda> venda = vendaService.listarTodos();
		model.addAttribute("venda", venda);
		return "balancas";
	}

	@RequestMapping(value= "salvarVenda", method = RequestMethod.POST)
	public String salvar(Venda venda, Model model){
		
		try{
			
			vendaService.salvar(venda);
		
		} catch(IllegalArgumentException e){
			e.getMessage();
		}
			
		return listarVendas(model);
	}

}
