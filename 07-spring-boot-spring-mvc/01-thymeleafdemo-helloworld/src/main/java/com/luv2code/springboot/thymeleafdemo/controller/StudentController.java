package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
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
    public String submitSignIn(@ModelAttribute("student") Student theStudent, Model model){
        System.out.println("Form Submitted!");

        String studentName = theStudent.getFirstName() + theStudent.getLastName();
        System.out.println(studentName);
        model.addAttribute("studentName", studentName );
        model.addAttribute("message", "Professor");
        return"greetings";
    }
}
