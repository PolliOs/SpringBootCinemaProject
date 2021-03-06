package com.example.demo.controllers.admin2.halls;


import com.example.demo.models.Hall;
import com.example.demo.models.validators.HallValidator;
import com.example.demo.service.IHallService;
import com.example.demo.service.exception.ContainerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddNewHallController {

    @Autowired
    IHallService hallService;

    @Autowired
    @Qualifier("hallValidator")
    Validator hallValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(hallValidator);
    }


    @GetMapping("/admin2/halls/addHall")
    public ModelAndView getIndexPage()
    {
        ModelAndView mv = new ModelAndView("admin2/halls/addHall");
        mv.addObject("hall", new Hall());
        return mv;
    }

    @PostMapping("/admin2/halls/addHall")
    public ModelAndView addMovieRecord(@ModelAttribute("hall") @Validated Hall hall, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin2/halls");

        if (result.hasErrors()) {
            mv.setViewName("admin2/halls/addHall");
            mv.addObject("hall", hall);
            return mv;
        }
        try {
            hallService.saveHallRecord(hall);
        }catch (ContainerException exceptions){
            HallValidator addHallValidator = new HallValidator();
            for(Exception ex: exceptions.getExceptions()) {
                if (ex.getMessage().equals("duplicate"))
                    addHallValidator.duplicateError(result);
                if (ex.getMessage().equals("seats"))
                    addHallValidator.seatsError(result);
            }
            mv.setViewName("admin2/halls/addHall");
            mv.addObject("hall", hall);
            return mv;
        }
        return mv;
    }

}


