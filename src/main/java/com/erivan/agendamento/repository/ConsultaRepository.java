package com.erivan.agendamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.erivan.agendamento.model.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

	Consulta findByCodigo(long codigo); // para o detalhe da consulta
	
	
}
