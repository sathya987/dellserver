package com.hcl.flightreservation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{

private Boolean checkedIn;
@Column(name="no_of_bags")
private int noOfBags;
@OneToOne
private Passenger passenger;
@OneToOne
private Flight flight;

public Boolean getCheckedIn() {
	return checkedIn;
}
public void setCheckedIn(Boolean checkedIn) {
	this.checkedIn = checkedIn;
}
public int getNoOfBags() {
	return noOfBags;
}
public void setNoOfBags(int noOfBags) {
	this.noOfBags = noOfBags;
}
public Passenger getPassenger() {
	return passenger;
}
public void setPassenger(Passenger passenger) {
	this.passenger = passenger;
}
public Flight getFlight() {
	return flight;
}
public void setFlight(Flight flight2) {
	this.flight = flight2;
}
}
