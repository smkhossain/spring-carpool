package com.example.carpool.reservation.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import model.BaseEntity;

@Entity
@Table(name="reservation")
@Getter
@Setter
public class Reservation extends BaseEntity{
	
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=true)
    private CustomerEntity customer;
    
    @ManyToOne
    @JoinColumn(name="driver_id", nullable=false)
    private Driver driver;
    
    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable=false)
    private Vehicle vehicle;
    
    @OneToOne
    @JoinColumn(name="pickup_location_id", nullable=false)
    private Location pickupLocation;
    
    @OneToOne
    @JoinColumn(name="dropoff_location_id", nullable=false)
    private Location dropoffLocation;
    
    @Column(name="start_time", columnDefinition = "TIMESTAMP" )
    private LocalDateTime startTime;
    
    @Column(name="end_time", columnDefinition = "TIMESTAMP" )
    private LocalDateTime endTime;
    
    @Column(name="wait_time", columnDefinition = "TIMESTAMP" )
    private LocalDateTime waitTime;
    
    @Enumerated(EnumType.ORDINAL)
    private Rating customerRating;
    
    @Enumerated(EnumType.ORDINAL)
    private Rating driverRating;
    
    
    @Enumerated(EnumType.ORDINAL)
    private ReservationStatus status;
    
	public static enum ReservationStatus {

		/**
		 * Placed, but not payed yet. Still changeable.
		 */
		PAYMENT_EXPECTED,

		/**
		 * Reservation was payed. No changes allowed to it anymore.
		 */
		PAID,

		/**
		 * The trip was completed.
		 */
		COMPLETED,
		
		/**
		 * The trip was cancelled by driver.
		 */
		CANCELLEDBYDRIVER,
		
		/**
		 * The trip was cancelled by customer.
		 */
		CANCELLEDBYCUSTOMER;
		
	}

}
