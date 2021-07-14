package br.com.gomes.mercadolivretreino.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String caracteristica;
    @NotBlank
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Caracteristica(Long id, String caracteristica, String descricao) {
        this.id = id;
        this.caracteristica = caracteristica;
        this.descricao = descricao;
    }
@Deprecated
    public Caracteristica(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
