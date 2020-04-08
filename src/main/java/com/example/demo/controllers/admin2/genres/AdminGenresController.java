package com.example.demo.controllers.admin2.genres;
import com.example.demo.models.Genre;
import com.example.demo.models.Hall;
import com.example.demo.service.IGenreService;
import com.example.demo.service.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminGenresController {

    @Autowired
    IGenreService genreService;

    @GetMapping("/admin2/genres")
    public ModelAndView getAllGenresPage(){
        List<Genre> genreList = genreService.getAllGenres();
        ModelAndView mv = new ModelAndView("admin2/genres/allGenres");
        mv.addObject("genres",genreList);
        mv.addObject("genre", new Genre());
        return mv;

    }
}


