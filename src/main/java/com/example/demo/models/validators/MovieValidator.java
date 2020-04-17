package com.example.demo.models.validators;

import com.example.demo.models.Movie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@Qualifier("movieValidator")
public class MovieValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "movieTitle", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration", "msg.field.required");
    }

    public final void duplicateError(final Errors errors){
        errors.rejectValue("movieTitle", "error.movie.duplicate");
    }
    public final void yearError(final Errors errors){errors.rejectValue("year", "error.movie.year");}
    public final void durationError(final Errors errors){errors.rejectValue("duration", "error.movie.duration");}

}
