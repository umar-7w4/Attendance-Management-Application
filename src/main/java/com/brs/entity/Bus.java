package com.brs.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


/*
 
 
  {
     "busName" : "Indira",
     "driverName" : "Raman",
     "busType" : "Volvo",
     "routeFrom" : "Vizag",
     "routeTo" : "Guntoor",
     "seats" : 56,
     "avaiableSeats" : 34,
     "arrivalTime" : "2020-04-14T10:45:07",
     "departureTime" : "2020-05-14T10:45:07"
  }
  
 */
@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	private String busName;
	private String driverName;
	private String busType;
	private String routeFrom;
	private String routeTo;

	private LocalDateTime arrivalTime;

	private LocalDateTime departureTime;
	
	private int seats;
	private int avaiableSeats;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "route_id", referencedColumnName = "routeId")
	private Route route;
	
	@OneToMany(mappedBy = "bus" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<FeedBack> feedbacks;
	
	@OneToMany(mappedBy = "bus" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Reservation> reservations;
	
	public Bus() {
		super();
	}

	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
			LocalDateTime arrivalTime, LocalDateTime departureTime, int seats, int avaiableSeats, Route route,
			List<FeedBack> feedbacks, List<Reservation> reservations) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avaiableSeats = avaiableSeats;
		this.route = route;
		this.feedbacks = feedbacks;
		this.reservations = reservations;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAvaiableSeats() {
		return avaiableSeats;
	}

	public void setAvaiableSeats(int avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<FeedBack> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
