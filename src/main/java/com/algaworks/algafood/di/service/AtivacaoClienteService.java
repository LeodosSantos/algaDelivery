package com.algaworks.algafood.di.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;

//@Component
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventMulticaster eventMulticaster;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		eventMulticaster.publishEvent(new ClienteAtivadoEvent(cliente));
	}
}
