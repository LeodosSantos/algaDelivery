package com.algaworks.algafood.jpa;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	@PersistenceContext
	EntityManager manager;
// gera uma lista de objetos da classe Cozinha
	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();

	}
	//busca um unico objeto na classe cozinha
	
	public Cozinha buscar(long id) {
		return manager.find(Cozinha.class, id);
	}
	
	// adicional no banco de dados um cadastro de cozinha
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}

}