package com.algaworks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;


public class AtivacaoClienteService {
	
	private Notificador notificador; /* o noftificador está sempre nulo */
		
	public AtivacaoClienteService(Notificador notificador) { /* fazendo injeção de dependencia pelo construtor*/
				this.notificador = notificador;
				System.out.println("AtivacaoClienteService " + notificador);
	}
	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente, " Seu cadastro no sistema está ativo!");
	}
}
