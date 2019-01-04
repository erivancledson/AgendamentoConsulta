package com.erivan.agendamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SegurancaController {
	
	
	
	@GetMapping("/403")
	public String acessoNegado() {
		return "403";
	}

}
