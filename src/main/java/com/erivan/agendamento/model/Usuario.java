package com.erivan.agendamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome_completo;
	private String telefone;
	@Column(unique = true)
	private String nome;
	private String senha;
	private boolean status;

    
    public Usuario() {};
    
  
    
    
	public Usuario(String nome_completo, String telefone, String nome, String senha, boolean status) {
		
		this.nome_completo = nome_completo;
		this.telefone = telefone;
		this.nome = nome;
		this.senha = senha;
		this.status = status;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	


	public String getNome_completo() {
		return nome_completo;
	}




	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


}
