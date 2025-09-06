package uy.com.labanca.notificaciones.infrastructure.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uy.com.labanca.notificaciones.infrastructure.validations.interfaces.IsNumeric;

public class IsNumericValidation implements ConstraintValidator<IsNumeric, String> {

    @Override
    public void initialize(IsNumeric constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String stringData, ConstraintValidatorContext constraintValidatorContext) {
        return isNumeric(stringData);
    }

    private boolean isNumeric(String value){
        try {
           Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
     return true;
    }
}
