package com.brs.service;

import java.time.LocalDate;
import java.util.List;

import com.brs.entity.Bus;
import com.brs.entity.Reservation;

public interface IReservationService {

	public Reservation addRoute(Reservation reservation) throws Exception;
	public Reservation updateRoute(Reservation reservation) throws Exception;
	public Reservation deleteRoute(int reservationId)throws Exception;
	public Reservation viewRoute(int reservationId) throws Exception;
	public List<Reservation> getAllReservation(LocalDate date)throws Exception;
	public List<Reservation> viewAllReservation()throws Exception;
	
}
