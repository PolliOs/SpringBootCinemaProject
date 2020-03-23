package com.example.demo.controllers.admin;

import com.example.demo.models.Book;
import com.example.demo.models.validators.BookValidator;
import com.example.demo.service.IBookService;
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

@Controller
public class AddNewBookController {

    @Autowired
    IBookService bookService;

    @Autowired
    @Qualifier("bookValidator")
    Validator bookValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(bookValidator);
    }


    @GetMapping("/admin/addBook")
    public ModelAndView getIndexPage()
    {
        ModelAndView mv = new ModelAndView("admin/library/addBook");
        mv.addObject("book", new Book());
        return mv;
    }

    @PostMapping("/admin/addBook")
    public ModelAndView addBookRecord(@ModelAttribute("book") @Validated Book book, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin");

        if (result.hasErrors()) {
            mv.setViewName("admin/library/addBook");
            mv.addObject("book", book);
            return mv;
        }
        try {
            bookService.saveBookRecord(book);
        }catch (Exception ex){
            BookValidator addBookValidator = new BookValidator();
            addBookValidator.custError(result);
        }
        return mv;
    }

}

