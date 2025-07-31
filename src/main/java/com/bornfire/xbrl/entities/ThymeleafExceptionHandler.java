package com.bornfire.xbrl.entities;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateInputException;
import org.thymeleaf.exceptions.TemplateProcessingException;

@ControllerAdvice
public class ThymeleafExceptionHandler {

    @ExceptionHandler({TemplateInputException.class, TemplateProcessingException.class})
    public ModelAndView handleThymeleafError(Exception ex) {
        // Log the error
        System.out.println("Thymeleaf error suppressed: " + ex.getMessage());

        // Redirect or return a fallback view (can be blank/safe)
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/home"); // Change this to your safe/default page
        return mv;
    }
}
