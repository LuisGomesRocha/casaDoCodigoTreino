package br.com.gomes.mercadolivretreino.config.handler;

import br.com.gomes.mercadolivretreino.config.error.ErroPadrao;
import br.com.gomes.mercadolivretreino.config.exception.ApiErrorException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;

@RestControllerAdvice
public class ConstraintExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroPadrao> handlerDataIntegrityException(DataIntegrityViolationException exception) {
        Collection<String> mensagens = new ArrayList<>();
        String detalhes;
        int index;

        index = exception.getCause().getCause().getLocalizedMessage().indexOf("Detail");
        detalhes = exception.getCause().getCause().getLocalizedMessage().substring(index);
        mensagens.add(detalhes);

        ErroPadrao erroPadrao = new ErroPadrao(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadrao);
    }

    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<ErroPadrao> handlerApiErrorException(ApiErrorException exception) {
        Collection<String> mensagens = new ArrayList<>();

        mensagens.add(exception.getMotivo());
        ErroPadrao erroPadrao = new ErroPadrao(mensagens);
        return ResponseEntity.status(exception.getHttpStatus()).body(erroPadrao);
    }

}
