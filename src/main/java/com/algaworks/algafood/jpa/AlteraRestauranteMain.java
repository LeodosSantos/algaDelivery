package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;



public class AlteraRestauranteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext
				.getBean(RestauranteRepository.class);
		Restaurante restaurante = new Restaurante();
		restaurante.setId(3L);
		restaurante.setNome("Mineirinho");
		restaurante.setTaxaFrete(new BigDecimal("7.7"));
		
	}
	
	

}