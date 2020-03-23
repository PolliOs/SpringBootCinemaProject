package com.example.demo.controllers.admin;

import com.example.demo.models.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminBooksController {

    @Autowired
    IBookService bookService;

    @GetMapping("admin/books")
    public ModelAndView getAllBooksPage(){
        List<Book> bookList = bookService.getAllBooks();
        ModelAndView mv = new ModelAndView("admin/library/allBooks");
        mv.addObject("books",bookList);
        return mv;

    }
}

