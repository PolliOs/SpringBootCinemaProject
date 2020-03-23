package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.models.Hall;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.HallsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CinemaMainController {
    final
    HallsRepository hallsRepository;

    public CinemaMainController(HallsRepository hallsRepository) {
        this.hallsRepository = hallsRepository;
    }

    @GetMapping("/cinema")
    public ModelAndView getIndexPage(){
        Iterable<Hall> halls = hallsRepository.findAll();
//        for (Book book: books) {
//            System.out.println(book.getBookTitle());
//
//        }
        return new ModelAndView("cinema/index");
    }

//    @GetMapping("/login")
//    public ModelAndView login() {
//        return new ModelAndView("login");
//    }
}
