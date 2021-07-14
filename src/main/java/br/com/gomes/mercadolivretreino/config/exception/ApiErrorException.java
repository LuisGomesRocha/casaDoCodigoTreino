package br.com.gomes.mercadolivretreino.config.exception;

import org.springframework.http.HttpStatus;

public class ApiErrorException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String motivo;

    public ApiErrorException(HttpStatus httpStatus, String motivo){
        super(motivo);
        this.httpStatus = httpStatus;
        this.motivo = motivo;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMotivo() {
        return motivo;
    }
}
