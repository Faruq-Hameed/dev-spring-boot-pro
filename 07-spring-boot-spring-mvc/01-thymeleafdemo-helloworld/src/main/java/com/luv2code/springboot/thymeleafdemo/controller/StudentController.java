package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.utils.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @GetMapping("signin")
    public String getSignInForm(Model model){

        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("signin")
    public void signin(Model model){
        Student student = (Student) model.getAttribute("student");
        System.out.println("Form Submitted!");
        System.out.println(student);
    }
}
