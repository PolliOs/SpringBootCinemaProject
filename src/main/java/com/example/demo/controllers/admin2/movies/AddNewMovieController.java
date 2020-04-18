package com.example.demo.controllers.admin2.movies;


import com.example.demo.models.Genre;
import com.example.demo.models.Movie;
import com.example.demo.models.validators.MovieValidator;
import com.example.demo.service.IGenreService;
import com.example.demo.service.IMovieService;
import com.example.demo.service.exception.ContainerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AddNewMovieController {

    @Autowired
    IMovieService movieService;

    @Autowired
    IGenreService genreService;

    @Autowired
    @Qualifier("movieValidator")
    Validator movieValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(movieValidator);
    }


    @GetMapping("/admin2/movies/addMovie")
    public ModelAndView getIndexPage()
    {
        ModelAndView mv = new ModelAndView("admin2/movies/addMovie");
        mv.addObject("movie", new Movie());
        return mv;
    }

    @PostMapping("/admin2/movies/addMovie")
    public ModelAndView addMovieRecord(@ModelAttribute("movie") @Validated Movie movie, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin2/movies");
        List<Genre> genreList = genreService.getAllGenres();
        mv.addObject("genres", genreList);
        if (result.hasErrors()) {
            mv.setViewName("admin2/movies/addMovie");
            mv.addObject("movie", movie);
            return mv;
        }
        try {
            movieService.saveMovieRecord(movie);
        }catch (ContainerException exceptions){
            MovieValidator addMovieValidator = new MovieValidator();
            exceptions.getExceptions().forEach(ex -> {
                if (ex.getMessage().equals("duplicate"))
                    addMovieValidator.duplicateError(result);
                if (ex.getMessage().equals("year"))
                    addMovieValidator.yearError(result);
                if (ex.getMessage().equals("duration")) addMovieValidator.durationError(result);
            });
            mv.setViewName("admin2/movies/addMovie");
            mv.addObject("movie", movie);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}


