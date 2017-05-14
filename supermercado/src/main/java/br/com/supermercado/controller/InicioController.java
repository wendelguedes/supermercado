package br.com.supermercado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InicioController {

	@RequestMapping(value = "")
	String index() {
		return "index";
	}

}
