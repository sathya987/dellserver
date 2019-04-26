package com.hcl.flightreservation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightreservation.dto.ReservationUpdateRequest;
import com.hcl.flightreservation.entities.Reservation;
import com.hcl.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepository.getOne(id);

	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setNoOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);

	}

}
