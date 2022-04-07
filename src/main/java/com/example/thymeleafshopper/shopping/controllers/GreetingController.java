package com.example.thymeleafshopper.shopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false,
            defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting.html";
    }

    /*
    //Denna kommer att overrida index.html ifall den inte är bortkommenterad
    @GetMapping("/")
    public @ResponseBody
    String test(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }
*/
}