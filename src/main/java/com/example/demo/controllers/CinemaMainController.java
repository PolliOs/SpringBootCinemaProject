package com.example.demo.controllers;

import com.example.demo.repository.HallsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CinemaMainController {
    final
    HallsRepository hallsRepository;

    public CinemaMainController(HallsRepository hallsRepository) {
        this.hallsRepository = hallsRepository;
    }

    @GetMapping("/cinema")
    public ModelAndView getIndexPage(){
        return new ModelAndView("cinema/index");
    }

//    @GetMapping("/login")
//    public ModelAndView login() {
//        return new ModelAndView("login");
//    }
}
