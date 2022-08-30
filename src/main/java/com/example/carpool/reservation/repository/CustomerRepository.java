package com.example.carpool.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.carpool.reservation.entity.CustomerEntity;



@SuppressWarnings("unused")
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	//@Query("SELECT c FROM CustomerEntity AS c where CONCAT(c.firstName,' ',c.lastName) like '%:name%'")
		
	
	//@Query("SELECT c FROM CustomerEntity AS c where (0<LOCATE(:name, CONCAT( c.firstName,' ',c.lastName)) ")
	
	@Query("SELECT c FROM CustomerEntity AS c where CONCAT(c.firstName,' ',c.lastName) like %:name%")
	List<CustomerEntity> findByName(@Param("name")String Name);
}


