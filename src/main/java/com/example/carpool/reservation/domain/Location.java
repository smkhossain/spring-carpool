package com.example.carpool.reservation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import model.BaseEntity;


@Entity
@Table(name="location")
@Getter
@Setter
public class Location extends BaseEntity {
	
	
	@Column(name = "address_line1")
	@NotBlank
	private String addressLine1;
	

	@Column(name = "address_line2")
	private String addressLine2;
	
	@Column(name = "city")
	@NotBlank
	private String city;
	
	@Column(name = "state")
	@NotBlank
	private String state;
	
	@Column(name = "country")
	@NotBlank
	private String country;
	
	@Column(name = "zipcode")
	@NotBlank
	private String zipcode;
	
	@Column(name = "landmark_name")
	private String landmarkName;
	
	
}
