package com.hcl.flightreservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.flightreservation.dto.ReservationRequest;
import com.hcl.flightreservation.entities.Flight;
import com.hcl.flightreservation.entities.Passenger;
import com.hcl.flightreservation.entities.Reservation;
import com.hcl.flightreservation.repos.FlightRepository;
import com.hcl.flightreservation.repos.PassengerRepository;
import com.hcl.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightrepository;
	@Autowired
	PassengerRepository passengerrepository;
	@Autowired
	ReservationRepository reservationrepository;
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// TODO Auto-generated method stub
		Long flightId=request.getFlightId();
		Flight flight=flightrepository.getOne(flightId);
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger=passengerrepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation=reservationrepository.save(reservation); 	
		return savedReservation;
	}

}
