package com.hcl.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.flightreservation.dto.ReservationRequest;
import com.hcl.flightreservation.entities.Flight;
import com.hcl.flightreservation.entities.Reservation;
import com.hcl.flightreservation.repos.FlightRepository;
import com.hcl.flightreservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightrepository;
	
	@Autowired
	ReservationService reservationservice;
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelmap) {
		Flight flight=flightrepository.getOne(flightId);
		modelmap.addAttribute("flight",flight);
		return "completeReservation";
		
	}
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelmap) {
		Reservation reservation=reservationservice.bookFlight(request);
		modelmap.addAttribute("msg","Reservation created successfully for Id :   "+reservation.getId());
		return "reservationConfirmation";
}
}
