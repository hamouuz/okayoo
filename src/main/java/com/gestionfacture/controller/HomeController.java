package com.gestionfacture.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class HomeController {
    @GetMapping(path = {"/"})
    public ModelAndView home() {
        return new ModelAndView("redirect:" + "/swagger-ui/index.html");
    }
}
