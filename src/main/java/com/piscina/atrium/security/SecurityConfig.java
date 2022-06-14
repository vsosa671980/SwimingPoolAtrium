package com.piscina.atrium.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity //For ability the security web
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //Injection of dependency
    @Autowired
    private UserDetailsService userDetailsService;

    //Method for Encrypt password;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //For authorization the url
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//for indicate the access of http requests
                .antMatchers("**/delete")
                   .hasRole("ADMIN")// Url
                .antMatchers("*/*")//url
                    .hasAnyRole("ADMIN","USER")
                .and()
                    .formLogin()//Url Login Page
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/users/list")//Template of login access
                    .usernameParameter("username")
                    .passwordParameter("password")

                .and()
                .exceptionHandling().accessDeniedPage("/Errors/403");
    }
 
     
}
