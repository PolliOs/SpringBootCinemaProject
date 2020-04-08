package com.example.demo.models.validators;

import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import com.example.demo.models.Hall;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@Qualifier("genreValidator")
public class GenreValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Genre.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genreTitle", "msg.field.required");
    }

    public final void duplicateError(final Errors errors){
        errors.rejectValue("genreTitle", "error.genres.duplicate");
    }


}
