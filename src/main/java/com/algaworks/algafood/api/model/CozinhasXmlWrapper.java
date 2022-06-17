package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhasXmlWrapper { // essa classe empacota uma lista de cozinha
	
	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
				// para gerar um construir pelo lombok tem que
	@NonNull // informar que é uma propriedade obrigatório no @NonNull
	private List<Cozinha> cozinhas;

}
