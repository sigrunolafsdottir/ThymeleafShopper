package com.example.thymeleafshopper.shopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/")
public class StaticController {

    @RequestMapping("/")
    public String hello1(){
        return "index.html";
    }

    @RequestMapping("/another")
    public String hello2(){
        return "anotherPage.html";
    }

}
