package com.example.carpool.reservation.web;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.carpool.reservation.dto.CustomerDto;
import com.example.carpool.reservation.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private CustomerService customerService;

	@Test
	void testCreateCustomerWhenValidInput() {
		
		CustomerDto c = new CustomerDto();
		c.setFirstName("Adam");
		c.setLastName("Smith");
		
	    mockMvc.perform(createCustomer("/forums/42/register")
	            .content(objectMapper.writeValueAsString(c))
	            .contentType("application/json"))
	            .andExpect(status().isOk());
		
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testListCustomer() {
		fail("Not yet implemented");
	}

}
