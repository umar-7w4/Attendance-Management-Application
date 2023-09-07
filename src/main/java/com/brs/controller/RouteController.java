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
import com.brs.service.IBusService;
import com.brs.service.IFeedBackService;
import com.brs.service.IReservationService;
import com.brs.service.IRouteService;

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
@RequestMapping("/brs-route")
public class RouteController {
	
	@Autowired 
	IRouteService iRouteService;
	
	@PostMapping("/addRoute")
	public Route addRoute(@RequestBody Route route) throws Exception{
		return iRouteService.addRoute(route);
	}
	
	@PutMapping("/updateRoute")
	public Route updateRoute(@RequestBody Route route) throws Exception{
		return iRouteService.updateRoute(route);
	}
	
	@DeleteMapping("/updateRoute/{routeId}")
	public Route deleteRoute(@PathVariable int routeId)throws Exception{
		return iRouteService.deleteRoute(routeId);
	}
	
	@GetMapping("/viewRoute/{routeId}")
	public Route viewRoute(@PathVariable int routeId) throws Exception{
		return iRouteService.viewRoute(routeId);
	}
	
	@GetMapping("/viewAllRoutes")
	public List<Route> viewAllRoutes()throws Exception{
		return iRouteService.viewAllRoutes();
	}

}
