package br.com.luisgomes.casaDoCodigoTreino.Categoria;

import javax.persistence.*;


@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nome;

	public Categoria() {
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}