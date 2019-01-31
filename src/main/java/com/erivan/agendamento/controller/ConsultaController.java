package com.erivan.agendamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erivan.agendamento.model.Consulta;
import com.erivan.agendamento.model.Paciente;
import com.erivan.agendamento.repository.ConsultaRepository;
import com.erivan.agendamento.repository.PacienteRepository;

@Controller

public class ConsultaController {

	@Autowired
	private ConsultaRepository cr;

	@Autowired
	private PacienteRepository pr;

	// chama a pagina de cadastro atraves desta url
	@RequestMapping(value = "/cadastrarConsulta", method = RequestMethod.GET)
	public String form() {
		return "consulta/formConsulta";
	}

	@RequestMapping(value = "/cadastrarConsulta", method = RequestMethod.POST)
	@CacheEvict(value = "listaConsultasPacientes", allEntries = true) // limpa o cache quando cadastra uma consulta
	public String form(@Valid Consulta consulta, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarConsulta";
		}

		// salva
		cr.save(consulta);
		attributes.addFlashAttribute("mensagem", "Consulta cadastrada com sucesso");
		return "redirect:/cadastrarConsulta";

	}

	@RequestMapping("consultas")
	@Cacheable(value = "listaConsultasPacientes") // cache
	public ModelAndView listaConsultas() {
		// chama o html
		ModelAndView mv = new ModelAndView("listaConsultas");
		Iterable<Consulta> consultas = cr.findAll();
		mv.addObject("consultas", consultas);
		return mv;
	}

	// detalhes da consulta
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesConsulta(@PathVariable("codigo") long codigo) {
		Consulta consulta = cr.findByCodigo(codigo);

		ModelAndView mv = new ModelAndView("consulta/detalhesConsulta");
		mv.addObject("consulta", consulta);
		// pacientes daquela consulta
		Iterable<Paciente> pacientes = pr.findByConsulta(consulta);
		mv.addObject("pacientes", pacientes);

		return mv;
	}

	// cadastrar paciente
	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detalhesConsultaCadastraPaciente(@PathVariable("codigo") long codigo, @Valid Paciente paciente,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}

		// recebe a consulta e passa o id dele para o paciente
		Consulta consulta = cr.findByCodigo(codigo);
		paciente.setConsulta(consulta);
		// salva o paciente
		pr.save(paciente);
		attributes.addFlashAttribute("mensagem", "Paciente adicionado com sucesso!");
		return "redirect:/{codigo}";
	}

	@RequestMapping("/deletarConsulta")
	@CacheEvict(value = "listaConsultasPacientes", allEntries = true) // limpa o cache quando deleta uma consulta
	public String deletarConsulta(long codigo) {
		Consulta consulta = cr.findByCodigo(codigo);
		cr.delete(consulta);
		return "redirect:/consultas";
	}

	// deletar o paciente
	@RequestMapping("/deletarPaciente")
	public String deletarPaciente(String cpf) {
		// recebe o cpf do paciente, para deletar
		Paciente paciente = pr.findByCpf(cpf);
		pr.delete(paciente);

		// depois de deletar redirecionapara a lista de consultas
		Consulta consulta = paciente.getConsulta();
		// recebe o id da consulta
		long codigoLong = consulta.getCodigo();
		// vai ficar assim "/"2 ex: recebe a barra e o codigo na url
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}

	// atualizar
	// editar
	@GetMapping("/edit/{codigo}")
	public String atualizarRecebeDados(@PathVariable("codigo") long codigo, Model model) {
		Consulta consulta = cr.findByCodigo(codigo);

		model.addAttribute("consulta", consulta);
		return "consulta/editarConsulta";
	}

	// atualiza os dados
	@PostMapping("/update/{codigo}")
	@CacheEvict(value = "listaConsultasPacientes", allEntries = true)
	public String updateUser(@PathVariable("codigo") long codigo, @Valid Consulta consulta, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			consulta.setCodigo(codigo);
			return "redirect:/consulta/editarConsulta";
		}

		cr.save(consulta);
		model.addAttribute("consultas", cr.findAll());
		return "redirect:/consultas";
	}

}
