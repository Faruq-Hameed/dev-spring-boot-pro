package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Configuration;

//No component scan here since we are doing that manually using config
public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("======== in Constructor: "+ getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkout(){
        return "<h1>Swimming Coach!</h1>";
    }
}
