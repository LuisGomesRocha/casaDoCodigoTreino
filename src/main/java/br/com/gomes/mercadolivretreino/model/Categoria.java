package br.com.gomes.mercadolivretreino.model;

import br.com.gomes.mercadolivretreino.response.CategoriaResponse;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    @ManyToOne
    @Nullable
    private Categoria mae;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Nullable
    public Categoria getMae() {
        return mae;
    }

    public void setMae(@Nullable Categoria mae) {
        this.mae = mae;
    }

    @Deprecated
    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(String nome, Categoria mae) {
        this.nome = nome;
        this.mae = mae;
    }


    public CategoriaResponse toResponse() {
        return new CategoriaResponse(this.id, this.nome);
    }
}
