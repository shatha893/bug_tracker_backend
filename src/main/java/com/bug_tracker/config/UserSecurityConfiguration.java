//package com.bug_tracker.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//import java.security.SecureRandom;
//
//@Configuration
//@EnableWebSecurity
//public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(int strength, SecureRandom secureRandom) {
//        return new BCryptPasswordEncoder(strength,secureRandom);
//    }
//}
