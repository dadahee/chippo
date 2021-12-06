package com.j2kb5th.chippo.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/swagger")
public class DocumentController {

    @GetMapping
    public String redicrectToSwagger(){
        return "redirect:/swagger-ui.html";
    }
}
