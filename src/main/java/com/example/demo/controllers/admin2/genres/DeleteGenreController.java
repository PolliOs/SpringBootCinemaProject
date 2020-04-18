package com.example.demo.controllers.admin2.genres;

import com.example.demo.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteGenreController {

    @Autowired
    IGenreService genreService;

    @PostMapping("/admin2/genres/deleteGenre/{id}")
    public ModelAndView deleteGenreInfo(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/admin2/genres");
        genreService.deleteGenreById(id);
        return mv;
    }
}
