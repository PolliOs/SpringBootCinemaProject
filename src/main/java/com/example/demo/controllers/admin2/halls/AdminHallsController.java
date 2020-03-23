package com.example.demo.controllers.admin2.halls;

import com.example.demo.models.Hall;
import com.example.demo.service.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminHallsController {

    @Autowired
    IHallService hallService;

    @GetMapping("/admin2/halls")
    public ModelAndView getAllHallsPage(){
        List<Hall> hallList = hallService.getAllHalls();
        ModelAndView mv = new ModelAndView("admin2/halls/allHalls");
        mv.addObject("halls",hallList);
        return mv;

    }
}

