package com.example.demo.controllers.admin2.halls;

import com.example.demo.service.IBookService;
import com.example.demo.service.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteHallController {

    @Autowired
    IHallService hallService;

    @PostMapping("/admin2/halls/deleteHall/{id}")
    public ModelAndView deleteBookInfo(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/admin2/halls");
        hallService.deleteHallById(id);
        return mv;
    }
}