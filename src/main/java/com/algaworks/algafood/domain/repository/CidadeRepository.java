package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {
	 void remover(Long id);
	List<Cidade> listar();
     Cidade buscar(Long id);
     Cidade salvar(Cidade cidade);
}
