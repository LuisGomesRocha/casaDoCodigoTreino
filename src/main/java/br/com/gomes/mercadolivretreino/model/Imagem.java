package br.com.gomes.mercadolivretreino.model;


import javax.persistence.*;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] imagem;
    @ManyToOne
    private Produto produto;

    public Imagem(Long id, byte[] imagem, Produto produto) {
        this.id = id;
        this.imagem = imagem;
        this.produto = produto;
    }

    @Deprecated
    public Imagem(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
