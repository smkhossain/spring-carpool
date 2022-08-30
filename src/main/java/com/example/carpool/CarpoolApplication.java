package com.example.carpool;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarpoolApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}	

	public static void main(String[] args) {
		SpringApplication.run(CarpoolApplication.class, args);
	}

}
