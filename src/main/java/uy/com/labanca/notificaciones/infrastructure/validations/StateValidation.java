package uy.com.labanca.notificaciones.infrastructure.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uy.com.labanca.notificaciones.infrastructure.validations.interfaces.State;

public class StateValidation implements ConstraintValidator<State, String> {
    @Override
    public void initialize(State constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String state, ConstraintValidatorContext constraintValidatorContext) {
        if(state !=null){
            if(state.equalsIgnoreCase("-1") || state.equalsIgnoreCase("2") || state.equalsIgnoreCase("-2"))
                return true;
        }
        return false;
    }
}
