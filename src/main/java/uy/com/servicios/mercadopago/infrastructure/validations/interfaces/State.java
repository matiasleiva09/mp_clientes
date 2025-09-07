package uy.com.servicios.mercadopago.infrastructure.validations.interfaces;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uy.com.servicios.mercadopago.infrastructure.validations.StateValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = StateValidation.class)
@Documented
public @interface State {
    String message() default "state valid  are -1 rollback, 2 win, -2 loose";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
