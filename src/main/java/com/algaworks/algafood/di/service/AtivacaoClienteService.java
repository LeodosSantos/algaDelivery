package com.algaworks.algafood.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;


@Component
public class AtivacaoClienteService {

	@TipoDoNotificador(Value = NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador; /* o noftificador está sempre nulo */

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
			notificador.notificar(cliente,"Seu cadastro no sistema está ativo! ");
		
	}

}
