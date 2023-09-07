package com.brs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.entity.Reservation;
import com.brs.entity.Route;
import com.brs.entity.User;
import com.brs.service.IBusService;
import com.brs.service.IFeedBackService;
import com.brs.service.IReservationService;
import com.brs.service.IRouteService;
import com.brs.service.IUserService;

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
@RequestMapping("/brs-user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) throws Exception{
		return iUserService.addUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) throws Exception{
		return iUserService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser")
	public User deleteUser(@PathVariable int userId)throws Exception{
		return iUserService.deleteUser(userId);
	}
	
	@GetMapping("/viewUser")
	public User viewUser(@PathVariable int userId) throws Exception{
		return iUserService.viewUser(userId);
	}
	
	@GetMapping("/viewAllUsers")
	public List<User> viewAllUsers()throws Exception{
		return iUserService.viewAllUsers();
	}

}
