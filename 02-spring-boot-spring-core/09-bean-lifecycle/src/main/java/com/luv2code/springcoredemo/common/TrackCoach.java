package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy //making this initialized after it is first needed instead of when app loaded
public class TrackCoach implements Coach{

    public TrackCoach (){
        System.out.println(" ============= In constructor " + getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkout(){
        return "Run a hard 5k as Track coach!";
    }
}
