package com.hcl.flightreservation.service;

import com.hcl.flightreservation.dto.ReservationRequest;
import com.hcl.flightreservation.entities.Reservation;

public interface ReservationService {
public Reservation bookFlight(ReservationRequest request);

}
