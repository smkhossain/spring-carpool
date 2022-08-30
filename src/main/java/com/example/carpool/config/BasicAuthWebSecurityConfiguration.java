package com.example.carpool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

@Configuration
@Import(SecurityProblemSupport.class)
public class BasicAuthWebSecurityConfiguration
{
  @Autowired
  private SecurityProblemSupport problemSupport;
	
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
    
    http.exceptionHandling()
    .authenticationEntryPoint(problemSupport)
    .accessDeniedHandler(problemSupport);

    return http.build();
  }

  
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User
        .withUsername("user")
        .password("{noop}testpass")
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
  }
}
