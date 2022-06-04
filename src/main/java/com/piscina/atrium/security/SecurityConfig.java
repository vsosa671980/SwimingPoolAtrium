package com.piscina.atrium.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity //For ability the security web
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Method for determinate the users of application
    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234")
                .roles("ADMIN","USER")
                .and()
                .withUser("user")
                .password("{noop}1234")
                .roles("USER");
    }

    //For authorization the url
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/insert","/**/save","/**/delete","/**/update")
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("USER","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login").permitAll()

                .and()
                .exceptionHandling().accessDeniedPage("/Errors/403");
    }
 
     
}
