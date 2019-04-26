package com.hcl.flightreservation.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.flightreservation.entities.Flight;
import com.hcl.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	FlightRepository flightrepository;
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,ModelMap modelmap) {

		List<Flight> flights=flightrepository.findFlights(from,to,departureDate);
		/*
		 * System.out.println("Fetched detail"); for(Flight f: flights) {
		 * System.out.println(f); }
		 */
		modelmap.addAttribute("flights",flights);
		return "displayFlights";
	}
	
	
	
	/*
	 * private Date getDate(String departureDate) { String[]
	 * ar=departureDate.split("-"); String m=ar[0]; int d=Integer.parseInt(ar[1]);
	 * String y=ar[2]; Date date=new Date(); date.setYear(1800+Integer.parseInt(y));
	 * date.setMonth(Integer.parseInt(m)); date.setDate(d);
	 * 
	 * // TODO Auto-generated method stub return date; }
	 */
}
