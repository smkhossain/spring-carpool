package com.example.carpool.reservation.querymodel;

import javax.validation.constraints.NotBlank;

public class CustomerQueryParam extends PageParam {
	
	public CustomerQueryParam() {
		
	}
	
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
