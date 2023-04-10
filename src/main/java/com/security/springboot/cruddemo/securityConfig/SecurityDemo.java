package com.security.springboot.cruddemo.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityDemo {

    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests( configurer ->
                    configurer
                            .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE,"/api/employees").hasRole("ADMIN")
            );
            http.httpBasic();
            http.csrf().disable();

            return http.build();
        }

        /*

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
                    .username("ahmet")
                    .password("{noop}ahmet123")
                    .roles("EMPLOYEE,ADMIN,MANAGER")
                    .build();

            return new InMemoryUserDetailsManager(yusuf,erkam,ahmet);
        }
        */


    }


