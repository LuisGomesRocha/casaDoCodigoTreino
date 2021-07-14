package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.request.UsuarioRequest;
import br.com.gomes.mercadolivretreino.response.UsuarioResponse;
import br.com.gomes.mercadolivretreino.service.UsuarioService;
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
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/novoUsuario")
    public ResponseEntity<UsuarioResponse> novoUsuario(@Validated @RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioRequest.toModel();
        usuarioService.salvarUsuario(usuario);
        UsuarioResponse usuarioResponse = usuario.toResponse();
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
    }
}
