package com.example.carpool.reservation.service;

import java.util.List;

import com.example.carpool.reservation.dto.CustomerDto;
import com.example.carpool.reservation.model.CustomerQueryParam;

public interface CustomerService {
	CustomerDto createCustomer(final CustomerDto customer);
	
	CustomerDto getCustomer(final Long id);
	
	CustomerDto updateCustomer(final CustomerDto customer);
	
	CustomerDto deleteCustomer(final CustomerDto customer);
	
	List<CustomerDto> listCustomer(final CustomerQueryParam customerQueryparam);
}
