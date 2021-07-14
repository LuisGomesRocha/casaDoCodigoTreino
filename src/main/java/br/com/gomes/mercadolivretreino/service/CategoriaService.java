package br.com.gomes.mercadolivretreino.service;

import br.com.gomes.mercadolivretreino.config.exception.ApiErrorException;
import br.com.gomes.mercadolivretreino.model.Categoria;
import br.com.gomes.mercadolivretreino.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void salvar(Categoria categoria, Long categoriaMae) {
        boolean existe = categoriaRepository.existsById(categoriaMae);

        if (!existe) {
            throw new ApiErrorException(HttpStatus.BAD_REQUEST, "Id da categoria mãe : " + categoriaMae + " não existe na base de dados.");
        }
        categoria.setMae(categoriaRepository.getById(categoriaMae));
        categoriaRepository.save(categoria);

    }

    public Categoria buscarCategoria(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).get();
    }
}
