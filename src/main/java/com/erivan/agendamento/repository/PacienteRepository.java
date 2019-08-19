package com.erivan.agendamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.erivan.agendamento.model.Consulta;
import com.erivan.agendamento.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
	Iterable<Paciente> findByConsulta(Consulta consulta);

	Paciente findByCpf(String cpf);
	


}
