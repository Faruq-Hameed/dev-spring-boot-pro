package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.utils.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @GetMapping("signin")
    public String getSignInForm(Model model){

        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("signin")
    public void signin(@ModelAttribute("student") Student theStudent){
        System.out.println("Form Submitted!");
        System.out.println(theStudent);
    }
}
