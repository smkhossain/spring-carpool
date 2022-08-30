package com.example.carpool;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)	
public class CarpoolApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}	

	public static void main(String[] args) {
		SpringApplication.run(CarpoolApplication.class, args);
	}

}
	