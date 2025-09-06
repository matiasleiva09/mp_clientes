package uy.com.labanca.notificaciones.infrastructure.validations.interfaces;



import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uy.com.labanca.notificaciones.infrastructure.validations.SqlInjectionPreventValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = SqlInjectionPreventValidation.class)
@Documented
public @interface SqlInjectionPrevent {
    String message() default "only numbers, letters and -";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}