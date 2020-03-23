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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditBookInfoController {

    @Autowired
    @Qualifier("bookValidator")
    Validator bookValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(bookValidator);
    }

    @Autowired
    IBookService bookService;

    @GetMapping("/admin/library/editBookInfo/{isbin}")
    public ModelAndView getEditPage(@PathVariable("isbin") String isbinNo) {
        ModelAndView mv = new ModelAndView("admin/library/editBookInfo");
        Book book = bookService.findBookByIsbinNo(isbinNo);
        mv.addObject("book", book);
        return mv;
    }



    @PostMapping("/admin/library/editBookInfo/{isbin}")
    public ModelAndView updateBookInfo(@ModelAttribute("book") @Validated Book bookToUpdate, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin/books");
        if (result.hasErrors()) {
            mv.setViewName("admin/library/editBookInfo");
            mv.addObject("book", bookToUpdate);
            return mv;
        }
        try {
            bookService.saveBookRecord(bookToUpdate);
        }catch (Exception ex){
            BookValidator addBookValidator = new BookValidator();
            addBookValidator.custError(result);
            mv.setViewName("admin/library/editBookInfo");
            mv.addObject("book", bookToUpdate);
            return mv;
        }
        return mv;
    }

}
