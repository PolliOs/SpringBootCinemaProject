package com.example.demo.controllers.admin2.genres;


import com.example.demo.models.Book;
import com.example.demo.models.Genre;
import com.example.demo.models.Hall;
import com.example.demo.models.validators.BookValidator;
import com.example.demo.models.validators.GenreValidator;
import com.example.demo.models.validators.HallValidator;
import com.example.demo.service.IBookService;
import com.example.demo.service.IGenreService;
import com.example.demo.service.IHallService;
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

import java.util.List;

@Controller
public class AddNewGenreController {

    @Autowired
    IGenreService genreService;

    @Autowired
    @Qualifier("genreValidator")
    Validator genreValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(genreValidator);
    }



    @PostMapping("/admin2/genres")
    public ModelAndView addGenreRecord(@ModelAttribute("genre") @Validated Genre genre, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin2/genres/allGenres");
        List<Genre> genreList = genreService.getAllGenres();
        mv.addObject("genres",genreList);
        if (result.hasErrors()) {
            mv.setViewName("/admin2/genres/allGenres");
            mv.addObject("genre", genre);
            return mv;
        }
        try {
            genreService.saveGenreRecord(genre);
        }catch (Exception ex){
            GenreValidator addGenreValidator = new GenreValidator();
            addGenreValidator.duplicateError(result);
            mv.setViewName("/admin2/genres/allGenres");
            mv.addObject("genre", genre);
            return mv;
        }
        return mv;
    }

}



