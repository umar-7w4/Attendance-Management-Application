package com.brs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.entity.Reservation;
import com.brs.repository.IReservationRepository;

@Service("IReservationService")
public class IReservationServiceImpl implements IReservationService{
	
	@Autowired
	IReservationRepository iReservationRepository;

	@Override
	public Reservation addRoute(Reservation reservation) throws Exception {
		iReservationRepository.saveAndFlush(reservation);
		return reservation;
	}

	@Override
	public Reservation updateRoute(Reservation reservation) throws Exception {
		Reservation  bean = null;
		try {
			bean = iReservationRepository.findById(reservation.getReservationId()).get();
		}
		catch(Exception e) {
			throw new Exception("Reservation details not found!");
		}
		iReservationRepository.saveAndFlush(reservation);
		return bean;
	}

	@Override
	public Reservation deleteRoute(int reservationId) throws Exception {
		Reservation  bean = null;
		try {
			bean = iReservationRepository.findById(reservationId).get();
		}
		catch(Exception e) {
			throw new Exception("Reservation details not found!");
		}
		iReservationRepository.deleteById(reservationId);
		return bean;
	}

	@Override
	public Reservation viewRoute(int reservationId) throws Exception {
		Reservation  bean = null;
		try {
			bean = iReservationRepository.findById(reservationId).get();
		}
		catch(Exception e) {
			throw new Exception("Reservation details not found!");
		}
		return bean;
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date) throws Exception {
		List<Reservation> ans = new ArrayList<Reservation>();
		try {
			for(Reservation i: iReservationRepository.findAll()) {
				if(i.getReservationDate() == date) {
					ans.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Reservation date details not found!");
		}
		return ans;
	}

	@Override
	public List<Reservation> viewAllReservation() throws Exception {
		return iReservationRepository.findAll();
	}

}
