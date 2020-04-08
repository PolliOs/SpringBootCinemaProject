package com.example.demo.controllers.admin2.halls;

import com.example.demo.models.Book;
import com.example.demo.models.Hall;
import com.example.demo.models.validators.BookValidator;
import com.example.demo.models.validators.HallValidator;
import com.example.demo.service.IBookService;
import com.example.demo.service.IHallService;
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

@Controller
public class EditHallController {

    @Autowired
    @Qualifier("hallValidator")
    Validator hallValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(hallValidator);
    }

    @Autowired
    IHallService hallService;

    @GetMapping("/admin2/halls/editHall/{id}")
    public ModelAndView getEditPage(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("admin2/halls/editHall");
        Hall hall = hallService.findHallById(id);
        mv.addObject("hall", hall);
        return mv;
    }



    @PostMapping("/admin2/halls/editHall/{id}")
    public ModelAndView updateHallInfo(@ModelAttribute("hall") @Validated Hall hallToUpdate, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin2/halls");
        if (result.hasErrors()) {
            mv.setViewName("admin2/halls/editHall");
            mv.addObject("hall", hallToUpdate);
            return mv;
        }
        try {
            hallService.saveHallRecord(hallToUpdate);
        }catch (ContainerException exceptions){
            HallValidator addHallValidator = new HallValidator();
            for(Exception ex: exceptions.getExceptions()) {
                if (ex.getMessage().equals("duplicate"))
                    addHallValidator.duplicateError(result);
                if (ex.getMessage().equals("seats"))
                    addHallValidator.seatsError(result);
            }
            mv.setViewName("admin2/halls/editHall");
            mv.addObject("hall", hallToUpdate);
            return mv;
        }
        return mv;
    }

}
