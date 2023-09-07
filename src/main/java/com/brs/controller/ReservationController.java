package com.brs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.entity.Reservation;
import com.brs.service.IBusService;
import com.brs.service.IFeedBackService;
import com.brs.service.IReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/brs-reservation")
public class ReservationController {
	
	@Autowired
	IReservationService iReservationService;
	
	@PostMapping("/addRoute")
	public Reservation addRoute(@RequestBody Reservation reservation) throws Exception{
		return iReservationService.addRoute(reservation);
	}
	
	@PutMapping("/updateRoute")
	public Reservation updateRoute(@RequestBody Reservation reservation) throws Exception{
		return iReservationService.updateRoute(reservation);
	}
	
	@DeleteMapping("/deleteRoute/{reservationId}")
	public Reservation deleteRoute(@PathVariable int reservationId)throws Exception{
		return iReservationService.deleteRoute(reservationId);
	}
	
	@GetMapping("/viewRoute/{reservationId}")
	public Reservation viewRoute(@PathVariable int reservationId) throws Exception{
		return iReservationService.viewRoute(reservationId);
	}
	
	@GetMapping("/getAllReservation")
	public List<Reservation> getAllReservation(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)throws Exception{
		return iReservationService.getAllReservation(date);
	}
	
	@GetMapping("/viewAllReservation")
	public List<Reservation> viewAllReservation()throws Exception{
		return iReservationService.viewAllReservation();
	}

}
