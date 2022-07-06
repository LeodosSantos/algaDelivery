package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
	
	List<Restaurante> findByTaxaFreteBetween (BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	List<Restaurante> findByNomeContaingAndCozinhaId(String nome, Long cozinha);
	
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinha); // não dá erro mesmo sem ser cozinhaId devido encapsulamento !!
}
