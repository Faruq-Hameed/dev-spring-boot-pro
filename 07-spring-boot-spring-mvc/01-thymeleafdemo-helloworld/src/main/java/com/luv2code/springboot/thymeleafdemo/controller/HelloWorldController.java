package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    //controller method to show the form
    @GetMapping("/form")
    public String showForm(){
        return "helloworld-form";
    }

    //controller method to show d form
    @PostMapping("/form")
//    @ResponseBody
    public String createHello(){
    return "helloworld";
    }
}
