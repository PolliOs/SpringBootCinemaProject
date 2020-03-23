package com.example.demo.controllers.admin;

import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteBookInfoController {

    @Autowired
    IBookService bookService;

    @PostMapping("/admin/library/deleteBook/{isbin}")
    public ModelAndView deleteBookInfo(@PathVariable("isbin") String isbin){
        ModelAndView mv = new ModelAndView("redirect:/admin/books");
        bookService.deleteBookByIsbin(isbin);
        return mv;
    }
}
