package com.carrental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrental.model.Rental;
@Repository
public interface RentalRepository extends JpaRepository<Rental,Integer> {
	
	

}
