package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

//@Controller-- componente spring controlador -- pode apagar
//@ResponseBody-- quando for acionado algum método get irá ter uma resposta -- pode apaga
@RestController // @RestController contém o @controller e o @ReponseBody
@RequestMapping(value = "/cozinhas") // produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastrocozinhaService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // requisições com ret http serão encaminhada para esse
														// método
	public List<Cozinha> listar() {
		System.out.println("Listar1");
		return cozinhaRepository.findAll();
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

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		
	Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);

		if (cozinha.isPresent()) {
			return ResponseEntity.ok(cozinha.get());
		}
		// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody Cozinha cozinha) {
		cadastrocozinhaService.salvar(cozinha);
	}

	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
		 Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);

		if (cozinhaAtual.isPresent()) {
			// cozinhaAtual.setNome(cozinha.getNome());
			BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");

			Cozinha cozinhaSalvar = cadastrocozinhaService.salvar(cozinhaAtual.get());
			return ResponseEntity.ok(cozinhaSalvar);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
		try {
			cadastrocozinhaService.excluir(cozinhaId);
			return ResponseEntity.noContent().build();
			
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
