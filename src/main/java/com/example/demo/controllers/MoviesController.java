package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MoviesController {

    @Autowired
    IMovieService movieService;

    @GetMapping("cinema/movies")
    public ModelAndView getAllMoviesPage(){
        List<Movie> movieList = movieService.getAllMovies();
        ModelAndView mv = new ModelAndView("cinema/movies/allMovies");
        mv.addObject("movies", movieList);
        return mv;

    }
}
