package br.com.luisgomes.casaDoCodigoTreino.Autor;

import java.util.Locale;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.luisgomes.casaDoCodigoTreino.Validador.VerificaCampoDuplicado;



public class AutorRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@VerificaCampoDuplicado(attribute = "email", clazz = Autor.class)
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.setEmail(email);
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase(Locale.ROOT);
	}

	

	public Autor toAutor() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
