package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

//@Controller-- componente spring controlador -- pode apagar
//@ResponseBody-- quando for acionado algum método get irá ter uma resposta -- pode apaga
@RestController // @RestController contém o @controller e o @ReponseBody
@RequestMapping(value = "/cozinhas") // produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // requisições com ret http serão encaminhada para esse
																// método
	public List<Cozinha> listar() {
		System.out.println("Listar1");
		return cozinhaRepository.listar();
	}

	// @ResponseStatus(value = HttpStatus.OK)
	// @GetMapping("/{cozinhaId}") // concatenando ---> /cozinhas/{cozinhaId} public
	// public Cozinha buscar(@PathVariable Long cozinhaId){
	// return cozinhaRepository.buscar(cozinhaId);
	// }

	/*
	 * @GetMapping("/{cozinhaId}") public ResponseEntity<Cozinha>
	 * buscar(@PathVariable Long cozinhaId){ Cozinha cozinha =
	 * cozinhaRepository.buscar(cozinhaId);
	 * 
	 * // return ResponseEntity.status(HttpStatus.OK).body(cozinha); // return
	 * ResponseEntity.ok(cozinha);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.add(HttpHeaders.LOCATION,"http://api.algafood.local:8080/cozinhas");
	 * 
	 * return ResponseEntity .status(HttpStatus.FOUND) .headers(headers) .build(); }
	 */

	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build();
	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml() {
		return new CozinhasXmlWrapper(cozinhaRepository.listar());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar (@RequestBody Cozinha cozinha) {
		cozinhaRepository.adicionar(cozinha);
	}
}
