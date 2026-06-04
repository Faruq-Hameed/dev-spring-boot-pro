package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component //marks the class as Bean
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "<h1>Practice fast bowling for15 minutes</h1>";
    }
}
