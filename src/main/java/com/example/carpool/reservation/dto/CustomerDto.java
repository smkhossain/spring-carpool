package com.example.carpool.reservation.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class CustomerDto {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;
	

    public static class SingleCustomer<T> {
        private T customer;

		public T getCustomer() {
			return customer;
		}

		public void setCustomer(T customer) {
			this.customer = customer;
		}
    }
    

    public static class MultipleCustomer {
        private List<CustomerDto> customers;

		public List<CustomerDto> getCustomers() {
			return customers;
		}

		public void setCustomers(List<CustomerDto> customers) {
			this.customers = customers;
		}
    }

}
