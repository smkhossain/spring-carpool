package com.example.carpool.reservation.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerDto {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SingleCustomer<T> {
        private T customer;
    }
    
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MultipleCustomer {
        private List<CustomerDto> customers;
    }

}
