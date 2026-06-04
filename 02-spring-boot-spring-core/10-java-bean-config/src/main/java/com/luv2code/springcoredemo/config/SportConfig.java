package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //configuring spring ourselves using this custom approach
public class SportConfig {

    @Bean("aquatic") /** aquatic is now the id not the default*/
//    @Bean the default bean id here will be the method name
    public Coach swimCoach() /** the default bean id*/{
        return  new SwimCoach();
    }
}
/** Steps to Configure java class
 * 1- create the config class and annotate ith @Configuration decorator
 * 2- create the bean method using the bean default id
 * 3- inject the bean into our controller to using the bean id
 * Use cases
 * 1- Make an existing third-party class available to Spring framework
 * Especially when we've access to the source code but it is a java class
 * */