package com.example.carpool.reservation.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import model.BaseEntity;

@Entity
@Table(name="driver")
@Getter
@Setter
public class Driver extends BaseEntity {

	@Column(name = "first_name")
	@NotBlank
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank
	private String lastName;
	
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id")
	private List<Reservation> reservations = new ArrayList<>();
	
}
