package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

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

    @PostMapping("/process")
//    public String processForm(HttpServletRequest request, Model model){
    public String processForm(@RequestParam String studentName,@RequestParam String id, Model model){
        //read the request parameter from the HTML form
//        String studentName = request.getParameter("studentName");
//        String studentName = req.
        //convert the name to upper case
        studentName = studentName.toUpperCase();

        //create the new message
        String message = "Happy to see you! " + studentName;

        //add the message to the model
        model.addAttribute("message", message);

        return "greetings";

    }
}
