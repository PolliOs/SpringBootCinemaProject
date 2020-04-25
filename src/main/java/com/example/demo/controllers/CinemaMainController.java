package com.example.demo.controllers;

import com.example.demo.repository.HallsRepository;
import com.example.demo.repository.MoviesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CinemaMainController {
    final
    HallsRepository hallsRepository;
    final
    MoviesRepository moviesRepository;

    public CinemaMainController(HallsRepository hallsRepository, MoviesRepository moviesRepository) {

        this.hallsRepository = hallsRepository;
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("/cinema")
    public ModelAndView getIndexPage(){
        return new ModelAndView("cinema/index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
