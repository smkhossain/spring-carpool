package com.example.carpool.reservation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.carpool.reservation.domain.CustomerEntity;
import com.example.carpool.reservation.dto.CustomerDto;
import com.example.carpool.reservation.model.CustomerQueryParam;
import com.example.carpool.reservation.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;

	@Override
	public CustomerDto createCustomer(CustomerDto customer) {
		
		CustomerEntity customerEntity = CustomerEntity.builder()
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.birthDate(customer.getBirthDate())
				.build();
		
		customerEntity = customerRepository.save(customerEntity);
		
		return convertEntityToDto(customerEntity);

	}

	@Override
	public CustomerDto getCustomer(CustomerDto customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto deleteCustomer(CustomerDto customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDto> listCustomer(CustomerQueryParam customerQueryparam) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private CustomerDto convertEntityToDto(CustomerEntity customerEntity) {
		
		return CustomerDto.builder()
				.id(customerEntity.getId())
				.firstName(customerEntity.getFirstName())
				.lastName(customerEntity.getLastName())
				.birthDate(customerEntity.getBirthDate())
				.build();
		
		
	}

}
