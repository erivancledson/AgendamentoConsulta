package com.erivan.agendamento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Paciente {
    @Id
    @NotEmpty
	private String cpf;
    
    @NotEmpty
	private String nome;
    
    @NotEmpty
	private String telefone;
    
    @NotEmpty
	private String idade;
	
	//muitos pacientes para uma consulta
	@ManyToOne
	private Consulta consulta;
	
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	
	
	
	
}
