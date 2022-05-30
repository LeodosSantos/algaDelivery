package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

//@Configuration
public class AlgaConfig {
	
	@Bean
	public NotificadorEmail notificadorEmail(){
		/*
		 * NotificadorEmail notificador= new NotificadorEmail("stmp.algamail.com.br");
		 * notificador.setCaixaAlta(true); return notificador;
		 */
		return null;
	}
	
//	@Bean
//	public AtivacaoClienteService ativacaoClienteService() {
//		return new AtivacaoClienteService(notificadorEmail());
//		
//	}
//	
//	
	

}
