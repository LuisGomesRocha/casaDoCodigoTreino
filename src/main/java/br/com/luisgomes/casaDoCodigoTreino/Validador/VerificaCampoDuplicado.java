package br.com.luisgomes.casaDoCodigoTreino.Validador;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { VerificaCampoDuplicadoValidator.class })
public @interface VerificaCampoDuplicado {

	String message() default "{VerificaCampoDuplicado}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String attribute();

	Class<?> clazz();

}