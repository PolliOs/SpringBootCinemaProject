package com.example.demo.controllers.admin2.sessions;

import com.example.demo.models.Hall;
import com.example.demo.models.Movie;
import com.example.demo.models.Session;
import com.example.demo.models.validators.SessionValidator;
import com.example.demo.service.IHallService;
import com.example.demo.service.IMovieService;
import com.example.demo.service.ISessionService;
import com.example.demo.service.exception.ContainerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EditSessionController {
    @Autowired
    @Qualifier("sessionValidator")
    Validator sessionValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(sessionValidator);
    }

    @Autowired
    ISessionService sessionService;

    @Autowired
    IMovieService movieService;

    @Autowired
    IHallService hallService;

    @GetMapping("/admin2/sessions/editSession/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("admin2/sessions/editSession");
        Session session = sessionService.findSessionById(id);
        addAllData(mv, session);
        return mv;
    }

    @PostMapping("/admin2/sessions/editSession/{id}")
    public ModelAndView updateSessionInfo(@ModelAttribute("session") @Validated Session sessionToUpdate, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin2/sessions");
        if (result.hasErrors()) {
            System.out.println("ERRORS");
            System.out.println(result.getAllErrors().toString());
            mv.setViewName("admin2/sessions/editSession");
            addAllData(mv, sessionToUpdate);
            return mv;
        }
        try {
            sessionService.saveSessionRecord(sessionToUpdate);
        }catch (ContainerException exceptions){
            SessionValidator addSessionValidator = new SessionValidator();
            for(Exception ex: exceptions.getExceptions()) {
                if (ex.getMessage().equals("price"))
                    addSessionValidator.priceError(result);
                if (ex.getMessage().equals("collision")) {
                    addSessionValidator.collisionError(result);
                }
            }
            mv.setViewName("admin2/sessions/editSession");
            addAllData(mv, sessionToUpdate);
            return mv;
        }
        return mv;
    }

    private void addAllData(ModelAndView mv, Session sessionToUpdate) {
        List<Movie> movieList = movieService.getAllMovies();
        List<Hall> hallList = hallService.getAllHalls();
        List<String> days = new ArrayList<>(
                List.of("Понеділок",
                        "Вівторок",
                        "Середа",
                        "Четвер",
                        "П'ятниця",
                        "Субота",
                        "Неділя"));

        mv.addObject("session", sessionToUpdate);
        mv.addObject("movies", movieList);
        mv.addObject("halls", hallList);
        mv.addObject("days", days);
    }
}
