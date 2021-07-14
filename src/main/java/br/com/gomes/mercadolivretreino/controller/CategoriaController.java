package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Categoria;
import br.com.gomes.mercadolivretreino.request.CategoriaRequest;
import br.com.gomes.mercadolivretreino.response.CategoriaResponse;
import br.com.gomes.mercadolivretreino.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaResponse> novaCategoria(@Validated @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();

        if (categoriaRequest.getMae() == null) {
            categoriaService.salvar(categoria);
        }else {
            categoriaService.salvar(categoria, categoriaRequest.getMae());
        }
        CategoriaResponse categoriaResponse = categoria.toResponse();

        return ResponseEntity.status(HttpStatus.OK).body(categoriaResponse);
    }
}
