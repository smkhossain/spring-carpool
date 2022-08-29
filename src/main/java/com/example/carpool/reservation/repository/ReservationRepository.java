package com.example.carpool.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carpool.reservation.domain.Reservation;



@SuppressWarnings("unused")
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
