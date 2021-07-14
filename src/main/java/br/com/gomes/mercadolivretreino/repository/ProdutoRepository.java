package br.com.gomes.mercadolivretreino.repository;

import br.com.gomes.mercadolivretreino.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
