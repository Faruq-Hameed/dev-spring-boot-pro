package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marks the class as Bean
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //SCOPE_SINGLETON is default either set or not
public class CricketCoach implements Coach{

    public CricketCoach (){
        System.out.println(" ============= In constructor " + getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkout() {
        return "<h1>Practice fast cricket bowling for15 minutes</h1>";
    }
}
