package com.example.carpool.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carpool.reservation.entity.DriverEntity;



@SuppressWarnings("unused")
@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {}