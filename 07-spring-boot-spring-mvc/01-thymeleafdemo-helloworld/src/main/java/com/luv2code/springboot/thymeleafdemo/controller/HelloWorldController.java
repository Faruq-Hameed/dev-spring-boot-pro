package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/v1")
public class HelloWorldController {
    //controller method to show the form
    @GetMapping()
    public String showForm(){
        return "helloworld-form";
    }

    //controller method to show d form
}
