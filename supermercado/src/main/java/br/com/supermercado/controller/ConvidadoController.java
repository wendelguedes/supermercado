package br.com.supermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.supermercado.model.Convidado;
import br.com.supermercado.service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/convidados")
	public String listaVipa(Model model){
		Iterable<Convidado> convidados = service.listarTodos();
		model.addAttribute("convidados", convidados);
		return "convidados";
	}

	@RequestMapping(value= "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model ){

		Convidado novoConvidado = new Convidado(nome, email, telefone);
		service.salvar(novoConvidado);

		Iterable<Convidado> convidados = service.listarTodos();
		model.addAttribute("convidados", convidados);

		return "convidados";
	}

}
