package br.com.luisgomes.casaDoCodigoTreino.categoria;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaRepository repository;

	public CategoriaController(CategoriaRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public void SalvarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) {

		repository.save(categoriaRequest.toCategoria());

	}

}
