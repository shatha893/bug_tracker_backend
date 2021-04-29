package com.bug_tracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private DataSource dataSource;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserSecurityConfiguration() {
    }

    @Autowired
    public UserSecurityConfiguration(DataSource dataSource, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dataSource = dataSource;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().authoritiesByUsernameQuery("select email,'role_user' from user where email = ?").dataSource(dataSource)
                .usersByUsernameQuery("SELECT email,password,1 FROM user WHERE email = ?")
                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/userRegistration").permitAll().anyRequest().authenticated()
                   .and()
                .formLogin();
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll();

    }
}
