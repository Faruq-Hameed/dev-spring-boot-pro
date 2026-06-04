package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//    inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    public String teamName;

    //expose endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "<h1>Coach: " + coachName + "</br> Team name: " + teamName + "</h1>";
    }

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

