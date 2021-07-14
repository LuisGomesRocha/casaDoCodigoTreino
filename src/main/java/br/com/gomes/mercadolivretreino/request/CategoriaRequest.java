package br.com.gomes.mercadolivretreino.request;

import br.com.gomes.mercadolivretreino.model.Categoria;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    private String nome;
    @Nullable
    private Long mae;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Nullable
    public Long getMae() {
        return mae;
    }

    public void setMae(@Nullable Long mae) {
        this.mae = mae;
    }
}
