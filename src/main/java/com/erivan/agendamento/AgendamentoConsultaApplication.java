package com.erivan.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching // habilita a funcionalidade Spring Caching
public class AgendamentoConsultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoConsultaApplication.class, args);
	
	}

}

