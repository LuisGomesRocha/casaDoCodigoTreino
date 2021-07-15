package br.com.luisgomes.casaDoCodigoTreino.autor;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private AutorRepository repository;

	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public void salvarAutor(@RequestBody @Valid AutorRequest autorRequest) {

		repository.save(autorRequest.toAutor());

	}

}