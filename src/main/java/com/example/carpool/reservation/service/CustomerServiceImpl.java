package com.example.carpool.reservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.jooq.DSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.carpool.reservation.dto.CustomerDto;
import com.example.carpool.reservation.entity.CustomerEntity;
import com.example.carpool.reservation.querymodel.CustomerQueryParam;
import com.example.carpool.reservation.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private ModelMapper modelMapper;	
	
	private final CustomerRepository customerRepository;

	@Override
	public CustomerDto createCustomer(CustomerDto customer) {
				
		CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
		
		customerEntity = customerRepository.save(customerEntity);
		
		return convertEntityToDto(customerEntity);

	}

	@Override
	public CustomerDto getCustomer(Long id) {
		Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
		
		return convertEntityToDto(customerEntity.get());
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customer) {
		
		Optional<CustomerEntity> dto = customerRepository.findById(customer.getId());
		
		CustomerEntity customerEntity = dto.get();
		
		if(customer.getFirstName()!=null)
		{
			customerEntity.setFirstName(customer.getFirstName());
		}
		if(customer.getLastName()!=null)
		{
			customerEntity.setLastName(customer.getLastName());
		}
		if(customer.getBirthDate()!=null)
		{
			customerEntity.setBirthDate(customer.getBirthDate());
		}
		
		customerRepository.save(customerEntity);
		
		return convertEntityToDto(customerEntity);

	}

	@Override
	public void deleteCustomer(CustomerDto customer) {
		Optional<CustomerEntity> customerEntity = customerRepository.findById(customer.getId());
		customerRepository.delete(customerEntity.get());
		
	}

	@Override
	public List<CustomerDto> listCustomer( CustomerQueryParam customerQueryparam) {
		
        Pageable pageable = null;
        if (customerQueryparam.getOffset() != null) {
            pageable = PageRequest.of(customerQueryparam.getOffset(), customerQueryparam.getLimit());
        }
        
        List<CustomerEntity> customerEntities;
        List<CustomerDto> customers = new ArrayList<>();
        
        if(customerQueryparam.getName() != null) {
        	customerEntities = customerRepository.findByName(customerQueryparam.getName());
        	customerEntities.forEach(e -> convertEntityToDto(e));
        	
        	
        	for (CustomerEntity c : customerEntities) {
        		
        		customers.add(convertEntityToDto(c));
			}
        	
        }
		       
		return customers;
		
	}
	
	private CustomerDto convertEntityToDto(CustomerEntity customerEntity) {
		
		CustomerDto customer = modelMapper.map(customerEntity, CustomerDto.class);
				
		return customer;
	}
	
	
	private CustomerEntity convertDtoEntity(CustomerDto customerDto) {
		
		CustomerEntity customer = modelMapper.map(customerDto, CustomerEntity.class);
				
		return customer;
	}

}
