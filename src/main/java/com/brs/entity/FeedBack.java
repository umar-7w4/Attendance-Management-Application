package com.brs.entity;

import java.time.LocalDate;

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
     "driverRating" : 5,
     "serviceRating" : 3,
     "overallRating" : 4,
     "comments" : "Nice",
     "feedbackdate" : "2023-01-02",
     "bus" :  
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
  }
  
 */

@Entity
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedBackId;
	private int driverRating;
	private int serviceRating;
	private int overallRating;
	private String comments;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate feedbackdate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_login_id", referencedColumnName = "userLoginId")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_id", referencedColumnName = "busId")
	private Bus bus;

	public FeedBack() {
		super();
	}

	public FeedBack(int feedBackId, int driverRating, int serviceRating, int overallRating, String comments,
			LocalDate feedbackdate, User user, Bus bus) {
		super();
		this.feedBackId = feedBackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedbackdate = feedbackdate;
		this.user = user;
		this.bus = bus;
	}

	public int getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}

	public int getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
	}

	public int getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(int serviceRating) {
		this.serviceRating = serviceRating;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getFeedbackdate() {
		return feedbackdate;
	}

	public void setFeedbackdate(LocalDate feedbackdate) {
		this.feedbackdate = feedbackdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	

}
