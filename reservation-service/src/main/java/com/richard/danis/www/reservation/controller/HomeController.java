package com.richard.danis.www.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Swagger home controller
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
