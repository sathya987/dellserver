package com.hcl.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	//Reservation findOne(Long id);

//	Reservation findOne(Long id);

}
