package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private  String teamName;
    //expose "/" that returns hello world

    @GetMapping("/")
    public String sayHello(){
        return  "<h1>Hello, Hello world! again</h1>" + coachName + teamName;
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "<h1>Run 100 laps in the morning <h1>";
    }

    @GetMapping("/fortune")
    public  String  getDailyFortune(){
        return "<h1>Today s your lucky day<h1>";
    }
}

