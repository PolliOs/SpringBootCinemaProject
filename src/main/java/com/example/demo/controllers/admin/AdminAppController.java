package com.example.demo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminAppController {

    @GetMapping("/admin")
    public ModelAndView getIndexPage() {
        return new ModelAndView("admin/index");
    }

}
