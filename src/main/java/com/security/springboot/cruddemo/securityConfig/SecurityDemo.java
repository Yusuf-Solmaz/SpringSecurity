package com.security.springboot.cruddemo.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityDemo {

        @Bean
        public InMemoryUserDetailsManager userDetailsManager(){

            UserDetails yusuf = User.builder()
                    .username("yusuf")
                    .password("{noop}yusuf123")
                    .roles("EMPLOYEE")
                    .build();

            UserDetails erkam = User.builder()
                    .username("erkam")
                    .password("{noop}erkam123")
                    .roles("EMPLOYEE,ADMIN")
                    .build();

            UserDetails ahmet = User.builder()
                    .username("erkam")
                    .password("{noop}erkam123")
                    .roles("EMPLOYEE,ADMIN,MANAGER")
                    .build();

            return new InMemoryUserDetailsManager(yusuf,erkam,ahmet);
        }

    }


