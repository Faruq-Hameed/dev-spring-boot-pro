package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(

            //Making a bean as the one to scan
            //the first letter of the class is the bean id which must be lower case.
            //Note that's same for both constructor and setter injections
            @Qualifier("cricketCoach") //Qualifier takes precedence over @Primary decorator
            Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach


    ){
        this.myCoach=theCoach;
        this.anotherCoach=theAnotherCoach;
        System.out.println("Comparing beans: myCoach == "+ myCoach + ". anotherCoach: " + anotherCoach);

    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.myCoach.getDailyWorkout();
    }

    @GetMapping("check")
    public String checkScope(){
        return "Comparing beans: myCoach == "+ myCoach + ". anotherCoach: " + anotherCoach;
    }
}