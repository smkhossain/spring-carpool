package com.example.carpool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ProblemHandlerConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        // In this example, stack traces support is enabled by default. 
        // If you want to disable stack traces just use new ProblemModule() instead of new ProblemModule().withStackTraces()
        return new ObjectMapper().registerModule(new JavaTimeModule()).registerModules(new ProblemModule().withStackTraces(), new ConstraintViolationProblemModule());
    }
}

