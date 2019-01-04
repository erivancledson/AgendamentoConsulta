package com.erivan.agendamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.erivan.agendamento.model.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, String>{

	Consulta findByCodigo(long codigo); //para o detalhe da consulta
}
