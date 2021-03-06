package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;


@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/unico-por-nome")
	public Optional<Cozinha> cozinhaPorNome(String nome) {
		return cozinhaRepository.findByNome(nome);
		
	}
	
	@GetMapping("/cozinhas/exists")
	public boolean cozinhaExists (String nome) {
		return cozinhaRepository.existsByNome(nome);
		
	}
	
	@GetMapping("/cozinha/primeiro")
	public Optional<Cozinha> cozinhaPrimeiro(){
		return cozinhaRepository.buscarPrimeiro();
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("/restautantes/por-nome")
	public List<Restaurante> restaurantesPorTaxaFrete(String nome, Long cozinhaId){
		return restauranteRepository.consultaPorNome(nome, cozinhaId);
	}

	@GetMapping("/restautantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantePrimeiroNome(String nome){
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}

	@GetMapping("/restautantes/top2-por-nome")
	public List<Restaurante> restaurantesPorNomeFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	@GetMapping("/restautantes/por-nome-e-frete")
	public List<Restaurante> restaurantesPorNomeFrete(String nome){
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/restautantes/count-por-cozinha")
	public int RestauranteCountPorcozinha(Long cozinha){
		return restauranteRepository.countByCozinhaId(cozinha);
	}
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restauranteComFreteGratisSpec(String nome){
		return restauranteRepository.findComFreteGratis(nome);
	}
	
	@GetMapping("/restaurantes/primeiro")
	public Optional<Restaurante> restaurantePrimeiro(){
		return restauranteRepository.buscarPrimeiro();
	}
	
}

