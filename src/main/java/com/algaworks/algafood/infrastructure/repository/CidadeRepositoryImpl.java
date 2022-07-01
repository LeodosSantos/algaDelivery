package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

	
	@PersistenceContext
	private EntityManager manager;
// gera uma lista de objetos da classe restaurante
	 @Override
     public List<Cidade> listar() {
         return manager.createQuery("from Cidade", Cidade.class)
                 .getResultList();
	}
	//busca um unico objeto na classe Restaurante
	 @Override
     public Cidade buscar(Long id) {
         return manager.find(Cidade.class, id);
	}
	
	// adicional no banco de dados um cadastro de Restaurante
	 @Transactional
     @Override
     public Cidade salvar(Cidade cidade) {
         return manager.merge(cidade);
	}
	// remove 
	 @Transactional
	    @Override
	    public void remover(Long id) {
	        Cidade cidade = buscar(id);
	        
	        if (cidade == null) {
	            throw new EmptyResultDataAccessException(1);
	        }
	        
	        manager.remove(cidade);
	    }
	    

}
