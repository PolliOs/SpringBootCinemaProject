package com.example.demo.controllers.admin2.sessions;

import com.example.demo.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteSessionController {

    @Autowired
    ISessionService sessionService;

    @PostMapping("/admin2/sessions/deleteSession/{id}")
    public ModelAndView deleteSessionInfo(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/admin2/sessions");
        sessionService.deleteSessionById(id);
        return mv;
    }
}
