package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    //using setter injection but constructor is recommended
    //setter injection is used mostly for optional deps injections
    @Autowired //aut
    public void setMyCoach /**any name can be used */(Coach theCoach){
        this.myCoach = theCoach;
    }

    @GetMapping("/")
    public String getDailyWorkout()
    {
        return this.myCoach.getDailyWorkout();
    }
}