package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marks the class as Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach (){
        System.out.println(" ============= In constructor " + getClass().getSimpleName());
/**
 * Comparing beans: myCoach == com.luv2code.springcoredemo.common.CricketCoach@6642abec. anotherCoach: com.luv2code.springcoredemo.common.CricketCoach@605f1616
 * Different address
 * So new object instance is created for each injection
 * */
    }
    @Override
    public String getDailyWorkout() {
        return "<h1>Practice fast cricket bowling for15 minutes</h1>";
    }
}
