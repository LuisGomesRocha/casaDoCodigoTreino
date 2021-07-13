package br.com.luisgomes.casaDoCodigoTreino.Categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.luisgomes.casaDoCodigoTreino.Validador.VerificaCampoDuplicado;


public class CategoriaRequest {

	@NotBlank
	@VerificaCampoDuplicado(attribute = "nome", clazz = Categoria.class)
	private String nome;

	@JsonCreator
	public CategoriaRequest(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria toCategoria() {
		return new Categoria(this.nome);
	}
}

