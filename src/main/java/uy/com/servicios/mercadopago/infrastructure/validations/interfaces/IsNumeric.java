package uy.com.servicios.mercadopago.infrastructure.validations.interfaces;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uy.com.servicios.mercadopago.infrastructure.validations.IsNumericValidation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = IsNumericValidation.class)
@Documented
public @interface IsNumeric {
    String message() default "the propertie is numeric";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}