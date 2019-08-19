package com.erivan.agendamento.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.erivan.agendamento.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Optional<Usuario> findByNome(String nome);
	
	

}
