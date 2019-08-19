package com.erivan.agendamento.security;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.erivan.agendamento.repository.UsuarioRepository;


@Component
public class UsuarioDetails implements UserDetailsService{
	//repositorio
		private UsuarioRepository usuarioRepository;

		public UsuarioDetails(UsuarioRepository usuarioRepository) {
			this.usuarioRepository = usuarioRepository;
		}
	

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		return usuarioRepository.findByNome(nome)
				.map(user -> new User(user.getNome(), user.getSenha(), user.isStatus(), 
						user.isStatus(), user.isStatus(), user.isStatus(),
						AuthorityUtils.createAuthorityList("USER")
						))
						.orElseThrow(() -> new UsernameNotFoundException("usuário não encontrado"));
	}


}
