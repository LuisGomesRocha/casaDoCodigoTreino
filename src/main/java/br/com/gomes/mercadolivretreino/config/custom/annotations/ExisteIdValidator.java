package br.com.gomes.mercadolivretreino.config.custom.annotations;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteIdValidator implements ConstraintValidator<ExistsId, Long> {

    private String campo;
    private Class<?> classe;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void initialize(ExistsId existsId) {
        campo = existsId.fieldName();
        classe = existsId.domainClass();
    }

    @Override
    public boolean isValid(Long idAtributo, ConstraintValidatorContext constraintValidatorContext) {
        Query customQuery = entityManager.createQuery("select 1 from " + classe.getName() + " where " + campo + " =: idAtributo");
        customQuery.setParameter("idAtributo", idAtributo);

        List<?> list = customQuery.getResultList();
        Assert.isTrue(list.size() <= 1, "Nenhum registro encontrado com os dados informados.");
        return !list.isEmpty();
    }
}
