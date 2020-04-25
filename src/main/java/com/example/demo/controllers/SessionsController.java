package com.example.demo.controllers;

import com.example.demo.models.Hall;
import com.example.demo.models.Session;
import com.example.demo.service.IHallService;
import com.example.demo.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SessionsController {

    @Autowired
    ISessionService sessionService;

    @GetMapping("cinema/sessions")
    public ModelAndView getAllSessionsPage(){
        List<Session> sessionList = sessionService.getAllSessions();
        ModelAndView mv = new ModelAndView("cinema/sessions/allSessions");
        mv.addObject("sessions", sessionList);
        return mv;

    }
}
