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
@Table(name="vehicle")
@Getter
@Setter
public class Vehicle extends BaseEntity{
	
	@Column(name = "vehicle_size")
	@NotBlank
	private String vehicleSize;
	
	@Column(name = "model")
	@NotBlank
	private String model;
	
	@Column(name = "last_servicing_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastServicingDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_id")
	private List<Reservation> reservations = new ArrayList<>();

}
