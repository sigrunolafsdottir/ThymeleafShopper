package com.example.thymeleafshopper.shopping.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("hi")
    public String hello1(){
        return "Hello World!";
    }

    @RequestMapping("esp")
    public String helloEsp(){
        return "Hola Mundo!";
    }

}
