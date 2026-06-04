package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marks the class as Bean
public class CricketCoach implements Coach{

    public CricketCoach (){
        System.out.println(" ============= In constructor " + getClass().getSimpleName());

    }

    /**PostConstruct Runs after the bean is created and dependencies are injected
     Good for: setting up resources, DB connections, loading config*/
    @PostConstruct //with this annotation, we can add our own custom initialization code e.g. loading db
    public void doMyStartupStuff(){ //init mehod
        System.out.println("In doMyStartupStuff() " + getClass().getSimpleName());
    }

    /** @PreDestroy
    Runs just before the bean is destroyed
    Good for: closing connections, releasing resources, cleanup*/
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff() : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "<h1>Practice fast cricket bowling for15 minutes</h1>";
    }
}

/** For "prototype" scoped beans, Spring does not call the destroy method. Gasp
 * Why Prototype skips @PreDestroy
 * After Spring hands off a prototype bean, it drops the reference — it no longer tracks that object.
 * So when shutdown happens, Spring has no record of it to call destroy on.
 * The object just gets garbage collected by the JVM eventually.
 * */