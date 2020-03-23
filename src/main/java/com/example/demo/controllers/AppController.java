package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    final
    BookRepository bookRepository;

    public AppController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/app")
    public ModelAndView getIndexPage(){
        Iterable<Book> books = bookRepository.findAll();
//        for (Book book: books) {
//            System.out.println(book.getBookTitle());
//
//        }
        return new ModelAndView("app/index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
