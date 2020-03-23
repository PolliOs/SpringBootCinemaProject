package com.example.demo.controllers.admin2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminCinemaController {

    @GetMapping("/admin2")
    public ModelAndView getIndexPage() {
        return new ModelAndView("admin2/index");
    }

}
