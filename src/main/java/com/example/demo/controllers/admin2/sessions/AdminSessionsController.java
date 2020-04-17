package com.example.demo.controllers.admin2.sessions;

import com.example.demo.models.Session;
import com.example.demo.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminSessionsController {
    @Autowired
    ISessionService sessionService;

    @GetMapping("/admin2/sessions")
    public ModelAndView getAllSessionsPage(){
        List<Session> sessionList = sessionService.getAllSessions();
        ModelAndView mv = new ModelAndView("admin2/sessions/allSessions");
        mv.addObject("sessions",sessionList);
        return mv;

    }
}
