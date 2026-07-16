package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );
        //define query to retrieve
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }



//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        // define query to retrieve a user by username
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select user_id, pw, active from members where user_id=?");
//
//        // define query to retrieve the authorities/roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select user_id, role from roles where user_id=?");
//
//        return jdbcUserDetailsManager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        //configure the every request must be authenticated
        httpSecurity.authorizeHttpRequests(configurer ->{

           configurer
                   .requestMatchers(HttpMethod.GET, "/api").anonymous()
                   .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                   .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE") //must have employee role to access
                   .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                   .requestMatchers(HttpMethod.PUT, "/api/employee/**").hasRole("ADMIN")
                   .requestMatchers(HttpMethod.PATCH, "/api/employee/**").hasRole("MANAGER")
                   .requestMatchers(HttpMethod.PUT, "/api/employee/**").hasRole("ADMIN")
                   .anyRequest().authenticated();
        });

        httpSecurity.httpBasic(Customizer.withDefaults()); //use basic auth
        httpSecurity.csrf(crsf -> crsf.disable());// disable crsf
        return httpSecurity.build();
    }

    /**
     @Bean
     //This is for UserDetails Managements i.e permitted users to sign in and make request
     public InMemoryUserDetailsManager userDetailsManager(){
     UserDetails john = User.builder()
     .username("john")
     .password("{noop}pass")
     .roles("EMPLOYEE")
     .build();
     System.out.println(john.getAuthorities());

     UserDetails mary = User.builder() //Building a user so no longer default
     .username("mary") //the username should be faruq
     .password("{noop}pass1") //the password is pass plainly i.e noop
     .roles("EMPLOYEE", "MANAGER")
     .build(); //now build this user.

     UserDetails susan = User.builder()
     .username("susan")
     .password("{noop}pass")
     .roles("EMPLOYEE", "MANAGER", "ADMIN")
     .build();

     UserDetails faruq = User.builder()
     .username("faruq")
     .password("{noop}pass")
     //                .roles("EMPLOYEE", "MANAGER", "ADMIN")//no role
     .build();
     return new InMemoryUserDetailsManager(john, mary, susan, faruq); //return the instance of InMemo...
     }

     */
}
