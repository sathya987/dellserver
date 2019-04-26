package com.hcl.flightreservation.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

@Entity
public class Flight extends AbstractEntity {

private String flightNumber;
private String operatingAirlines;
private String departureCity;
private String arrivalCity;
@Column(name="DATE_OF_DEPARTURE")
private Date dateofDeparture;
@Column(name="estimated_departure_time",columnDefinition = "DATETIME")
@javax.persistence.Temporal(TemporalType.TIMESTAMP)
private Date estimated_departure_time;

public String getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(String flightNumber) {
	this.flightNumber = flightNumber;
}
public String getOperatingAirlines() {
	return operatingAirlines;
}
public void setOperatingAirlines(String operatingAirlines) {
	this.operatingAirlines = operatingAirlines;
}
public String getDepartureCity() {
	return departureCity;
}
public void setDepartureCity(String departureCity) {
	this.departureCity = departureCity;
}
public String getArrivalCity() {
	return arrivalCity;
}
public void setArrivalCity(String arrivalCity) {
	this.arrivalCity = arrivalCity;
}
public Date getDateofDeparture() {
	return dateofDeparture;
}
public void setDateofDeparture(Date dateofDeparture) {
	this.dateofDeparture = dateofDeparture;
}
public Date getEstimatedDepartureTime() {
	return estimated_departure_time;
}
public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
	this.estimated_departure_time = estimated_departure_time;
}
@Override
public String toString() {
	return "Flight [flightNumber=" + flightNumber + ", operatingAirlines=" + operatingAirlines + ", departureCity="
			+ departureCity + ", arrivalCity=" + arrivalCity + ", dateofDeparture=" + dateofDeparture
			+ ", estimated_departure_time=" + estimated_departure_time + "]";
}

}
