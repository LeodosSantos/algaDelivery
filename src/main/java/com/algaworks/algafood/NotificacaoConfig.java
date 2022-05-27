package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {

	@Bean
	public NotificadorEmail notificadorEmail(){
		NotificadorEmail notificador= new NotificadorEmail("stmp.algamail.com.br");
		notificador.setCaixaAlta(true);
		return notificador;
	}
}
