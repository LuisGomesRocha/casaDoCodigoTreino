package br.com.gomes.mercadolivretreino.controller;

import br.com.gomes.mercadolivretreino.model.Categoria;
import br.com.gomes.mercadolivretreino.model.Imagem;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import br.com.gomes.mercadolivretreino.request.ProdutoRequest;
import br.com.gomes.mercadolivretreino.request.UsuarioRequest;
import br.com.gomes.mercadolivretreino.response.ProdutoResponse;
import br.com.gomes.mercadolivretreino.response.UsuarioResponse;
import br.com.gomes.mercadolivretreino.service.CategoriaService;
import br.com.gomes.mercadolivretreino.service.ProdutoService;
import br.com.gomes.mercadolivretreino.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<ProdutoResponse> novoProduto(@Validated @RequestBody ProdutoRequest produtoRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().getCredentials();
        Produto produto = produtoRequest.toModel(categoriaService.buscarCategoria(produtoRequest.getCategoria()), usuario);

        produto.setUsuario(usuario);
        produtoService.salvarProduto(produto);
        ProdutoResponse produtoResponse = produto.toResponse();
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);

    }

    @PostMapping("/imagem/{produtoId}")
    public ResponseEntity<String> novaImagem(@PathVariable Long produtoId, MultipartFile imagem) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().getCredentials();
        Produto produto = usuario.getProdutos().stream().filter(p -> p.getId().equals(produtoId)).findFirst().orElse(null);
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Produto que não é seu");
        }
        produtoService.salvarImagem(produto, imagem);
        return ResponseEntity.status(HttpStatus.OK).body("Imagem adicionada com sucesso!");

    }

    @GetMapping("/imagem/abc")
    public void verImagem(HttpServletResponse response) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();
        SecurityContextHolder.getContext().getAuthentication().getCredentials();
        Imagem imagem = usuario.getProdutos().get(0).getImagens().get(0);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(new ByteArrayInputStream(imagem.getImagem()),response.getOutputStream());

    }
}
