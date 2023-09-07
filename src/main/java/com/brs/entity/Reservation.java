package com.brs.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/*
 
  {
    "reservationStatus" : "Booked",
     "reservationType" : "single",
     "reservationDate" : "2023-01-02",
     "reservationTime"  : "2023-01-02T10:45:07",
     "source" : "mumbai",
     "destination" : "destination",
     "bus" :   {
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
  
  }
  
  
 */

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	private String reservationStatus;
	private String reservationType;
	
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate reservationDate;
	
	private LocalDateTime reservationTime;
	
	private String source;
	private String destination;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_id", referencedColumnName = "busId")
	private Bus bus;

	public Reservation() {
		super();
	}

	public Reservation(int reservationId, String reservationStatus, String reservationType, LocalDate reservationDate,
			LocalDateTime reservationTime, String source, String destination, Bus bus) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public LocalDateTime getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(LocalDateTime reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	

}
