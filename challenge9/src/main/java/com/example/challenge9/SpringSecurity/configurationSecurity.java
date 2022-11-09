package com.example.challenge9.SpringSecurity;


import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;


@Configuration
@EnableWebSecurity
public class configurationSecurity   {



    /*Authentication*/

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("12345").roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("54321").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user , admin);
    }

    /*Authorization*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

          http.authorizeRequests()
                .antMatchers("/").permitAll()
                 .antMatchers("/user").hasAnyRole("USER","ADMIN")
                 .antMatchers("/admin").hasRole("ADMIN")
                 .and().formLogin();

          return http.build();
    }











  }
