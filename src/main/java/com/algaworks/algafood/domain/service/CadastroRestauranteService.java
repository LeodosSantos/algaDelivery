package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired // eu preciso injetar cozinha para conseguir tratar: fazer uma consulta uma
				// busca
	CozinhaRepository cozinhaRepository;

	public Restaurante Salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

		if (cozinha == null) {

			throw new EntidadeNaoEncontradaException(
					String.format("Não existi cadastro de cozinha com código %d ", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha);

		return restauranteRepository.salvar(restaurante);

	}

}