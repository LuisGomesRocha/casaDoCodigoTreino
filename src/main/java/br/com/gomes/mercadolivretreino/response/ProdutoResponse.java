package br.com.gomes.mercadolivretreino.response;

public class ProdutoResponse {

    private Long id;
    private String nome;

    public ProdutoResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
