package com.example.demo.models.validators;

import com.example.demo.models.Hall;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@Qualifier("hallValidator")
public class HallValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Hall.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hallTitle", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seats", "msg.field.required");
    }

    public final void duplicateError(final Errors errors){
        errors.rejectValue("hallTitle", "error.halls.duplicate");
    }
    public final void seatsError(final Errors errors) {
        errors.rejectValue("seats", "error.halls.seats");
    }


}
