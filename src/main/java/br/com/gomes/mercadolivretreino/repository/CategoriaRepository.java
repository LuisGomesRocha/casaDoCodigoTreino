package br.com.gomes.mercadolivretreino.repository;

import br.com.gomes.mercadolivretreino.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
