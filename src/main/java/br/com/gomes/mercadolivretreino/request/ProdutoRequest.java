package br.com.gomes.mercadolivretreino.request;

import br.com.gomes.mercadolivretreino.config.custom.annotations.ExistsId;
import br.com.gomes.mercadolivretreino.model.Caracteristica;
import br.com.gomes.mercadolivretreino.model.Categoria;
import br.com.gomes.mercadolivretreino.model.Produto;
import br.com.gomes.mercadolivretreino.model.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRequest {

    @NotBlank
    private String nome;
    @Positive
    @NotNull
    private BigDecimal valor;
    @Positive
    @NotNull
    private int quantidade;
    private List<Caracteristica> caracteristicas;
    @NotBlank
    @Length(max = 1000)
    private String descricao;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoria;

    public ProdutoRequest(String nome, BigDecimal valor, int quantidade, List<Caracteristica> caracteristicas, String descricao, Long categoria) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Produto toModel(Categoria categoria, Usuario usuario) {
        return new Produto(
                this.nome,
                this.valor,
                this.quantidade,
                this.caracteristicas,
                this.descricao,
                categoria,
                usuario
        );
    }
}
