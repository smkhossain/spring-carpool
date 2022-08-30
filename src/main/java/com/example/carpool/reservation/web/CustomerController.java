package com.example.carpool.reservation.web;


import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carpool.reservation.dto.CustomerDto;
import com.example.carpool.reservation.querymodel.CustomerQueryParam;
import com.example.carpool.reservation.service.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;
import util.exceptions.CustomerNotFoundException;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	private final CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer){
		
		return new ResponseEntity<CustomerDto>(customerService.createCustomer(customer),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id){
		
		try {
			return new ResponseEntity<CustomerDto>(customerService.getCustomer(id),HttpStatus.FOUND);
		}catch(NoSuchElementException ne) {
			throw new CustomerNotFoundException(id);
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customer){
		
		try {
			return new ResponseEntity<CustomerDto>(customerService.updateCustomer(customer),HttpStatus.OK);
		}catch(NoSuchElementException ne) {
			throw new CustomerNotFoundException(customer.getId());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> listCustomer(@Valid CustomerQueryParam customerQueryParam){
		
		logger.trace("in list customer");
		logger.debug(customerQueryParam.getName());	
		
		return new ResponseEntity<List<CustomerDto>>(customerService.listCustomer(customerQueryParam),HttpStatus.FOUND);
	}
	
	// Example of using custom exception handler
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        throw new AccessDeniedException("You can't delete this customer");
    }

}
