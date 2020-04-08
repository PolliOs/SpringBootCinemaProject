package com.example.demo.controllers.admin2.movies;
import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import com.example.demo.models.Hall;
import com.example.demo.models.Movie;
import com.example.demo.models.validators.BookValidator;
import com.example.demo.models.validators.HallValidator;
import com.example.demo.models.validators.MovieValidator;
import com.example.demo.service.IBookService;
import com.example.demo.service.IGenreService;
import com.example.demo.service.IHallService;
import com.example.demo.service.IMovieService;
import com.example.demo.service.exception.ContainerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EditMovieController {

    @Autowired
    @Qualifier("movieValidator")
    Validator movieValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(movieValidator);
    }

    @Autowired
    IMovieService movieService;

    @Autowired
    IGenreService genreService;

    @GetMapping("/admin2/movies/editMovie/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("admin2/movies/editMovie");
        Movie movie = movieService.findMovieById(id);
        mv.addObject("movie", movie);
        List<Genre> genreList = genreService.getAllGenres();
        mv.addObject("genres", genreList);
        return mv;
    }



    @PostMapping("/admin2/movies/editMovie/{id}")
    public ModelAndView updateMovieInfo(@ModelAttribute("movie") @Validated Movie movieToUpdate, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin2/movies");
        if (result.hasErrors()) {
            mv.setViewName("admin2/movies/editMovie");
            mv.addObject("movie", movieToUpdate);
            return mv;
        }
        try {
            movieService.saveMovieRecord(movieToUpdate);
        }catch (ContainerException exceptions){
            MovieValidator addMovieValidator = new MovieValidator();
            for(Exception ex: exceptions.getExceptions()) {
                if (ex.getMessage().equals("duplicate"))
                    addMovieValidator.duplicateError(result);
                if (ex.getMessage().equals("year"))
                    addMovieValidator.yearError(result);
                if(ex.getMessage().equals("duration")) addMovieValidator.durationError(result);
            }
            mv.setViewName("admin2/movies/editMovie");
            mv.addObject("movie", movieToUpdate);
            return mv;
        }
        return mv;
    }

}

