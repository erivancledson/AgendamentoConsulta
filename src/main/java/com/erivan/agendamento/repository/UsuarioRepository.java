package com.erivan.agendamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.erivan.agendamento.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login); //realiza a busca do usuario pelo login
	
}
