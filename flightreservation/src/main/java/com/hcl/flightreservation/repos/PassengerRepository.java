package com.hcl.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
