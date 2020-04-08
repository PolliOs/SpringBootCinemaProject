package com.example.demo.controllers.admin2.movies;

import com.example.demo.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteMovieController {

    @Autowired
    IMovieService movieService;

    @PostMapping("/admin2/movies/deleteMovie/{id}")
    public ModelAndView deleteMovieInfo(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/admin2/movies");
        movieService.deleteMovieById(id);
        return mv;
    }
}
