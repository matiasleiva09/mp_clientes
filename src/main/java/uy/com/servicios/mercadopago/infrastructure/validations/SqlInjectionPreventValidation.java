package uy.com.servicios.mercadopago.infrastructure.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uy.com.servicios.mercadopago.infrastructure.validations.interfaces.SqlInjectionPrevent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlInjectionPreventValidation implements ConstraintValidator<SqlInjectionPrevent, String>
{

    @Override
    public void initialize(SqlInjectionPrevent constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String campo, ConstraintValidatorContext constraintValidatorContext) {
       boolean resultado = false;
       if(campo!=null && !campo.equalsIgnoreCase(""))
       {
           String regex = "^[a-zA-Z0-9-]+$";
           Pattern pattern = Pattern.compile(regex);
           Matcher matcher = pattern.matcher(campo);
           if (matcher.matches())
               resultado=true;
       }
        return resultado;
    }
}
