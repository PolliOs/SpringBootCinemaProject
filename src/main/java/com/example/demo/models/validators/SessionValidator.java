package com.example.demo.models.validators;

import com.example.demo.models.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
@Qualifier("sessionValidator")
public class SessionValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Session.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "msg.field.required");
    }
    public final void priceError(final Errors errors){errors.rejectValue("price", "error.session.price");}
    public final void collisionError(final Errors errors){errors.rejectValue("hall", "error.session.collision");}

}
