package br.com.gomes.mercadolivretreino.model;

import br.com.gomes.mercadolivretreino.response.ProdutoResponse;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @Positive
    private BigDecimal valor;
    @Positive
    private int quantidade;
    @NotNull
    @Size(min = 3)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "produto", orphanRemoval = true)
    private List<Caracteristica> caracteristicas;
    @NotBlank
    @Length(max = 1000)
    private String descricao;
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "produto", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Imagem> imagens;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    private LocalDateTime instanteCadastro = now();
    @ManyToOne
    @NotNull
    private Usuario usuario;

    public Produto(String nome, BigDecimal valor, int quantidade, List<Caracteristica> caracteristicas, String descricao, Categoria categoria, Usuario usuario) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.imagens = new ArrayList<>();
        this.categoria = categoria;
        this.usuario = usuario;
    }
    @Deprecated
    public Produto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ProdutoResponse toResponse() {
        return new ProdutoResponse(this.id, this.nome);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
}
