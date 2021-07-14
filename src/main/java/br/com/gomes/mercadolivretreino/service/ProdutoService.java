package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.model.Imagem;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public void salvarProduto(Produto produto) {
        produto.getCaracteristicas().forEach(categoria -> categoria.setProduto(produto)); // Israel :D
        produtoRepository.save(produto);
    }

    public void salvarImagem(Produto produto, MultipartFile imagem) throws IOException {
        Imagem figura = new Imagem(null,imagem.getBytes(),produto);
        produto.getImagens().add(figura);
        produtoRepository.save(produto);
    }

}
