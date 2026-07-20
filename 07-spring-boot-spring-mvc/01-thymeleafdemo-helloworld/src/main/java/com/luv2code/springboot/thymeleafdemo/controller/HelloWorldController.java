package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
    //controller method to show the form
    @GetMapping("/form")
    public String showForm(){
        return "helloworld-form";
    }

    //controller method to show d form
    @PostMapping("/hello")
    public String createHello(Model model){

    }
}
