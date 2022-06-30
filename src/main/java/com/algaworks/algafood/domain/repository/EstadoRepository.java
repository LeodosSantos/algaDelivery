package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;


public interface EstadoRepository {
	void remover(Long estadoId);
	
	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);

}
