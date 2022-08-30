package com.example.carpool.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carpool.reservation.entity.LocationEntity;



@SuppressWarnings("unused")
@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {}