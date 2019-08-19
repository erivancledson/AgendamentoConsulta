package com.erivan.agendamento.model;

public class UsuarioLogin {
	
	//recebe o usuario para gravar no banco de dados usuario, mas nessa classe ela recebe os dados para ser codificada a senha
	private String nome;
	private String senha;
	
	public UsuarioLogin() {}
	
	public UsuarioLogin(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
