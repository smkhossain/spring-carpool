package com.example.carpool.reservation.web;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carpool.reservation.dto.CustomerDto;
import com.example.carpool.reservation.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	@PostMapping
	public CustomerDto.SingleCustomer<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto.SingleCustomer<CustomerDto> customer ){
		
		return new CustomerDto.SingleCustomer<>(customerService.createCustomer(customer.getCustomer()));
	}

}
