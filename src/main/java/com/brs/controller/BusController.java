package com.brs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Bus;
import com.brs.service.IBusService;

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
@RequestMapping("/brs-bus")
public class BusController {
	
	@Autowired
	IBusService iBusService;
	
	@PostMapping("/addBus")
	public Bus addBus(@RequestBody Bus bus) throws Exception{
		return iBusService.addBus(bus);
	}
	
	@PutMapping("/updateBus")
	public Bus updateBus(@RequestBody Bus bus) throws Exception{
		return iBusService.updateBus(bus);
	}
	
	@DeleteMapping("/deleteBus/{busId}")
	public Bus deleteBus(@PathVariable int busId)throws Exception{
		return iBusService.deleteBus(busId);
	}
	
	@GetMapping("/viewBus/{busId}")
	public Bus viewBus(@PathVariable int busId) throws Exception{
		return iBusService.viewBus(busId);
	}
	
	@GetMapping("/viewBusByType/{busType}")
	public List<Bus> viewBusByType(@PathVariable String busType)throws Exception{
		return iBusService.viewBusByType(busType);
	}
	
	@GetMapping("/viewAllBus")
	public List<Bus> viewAllBus()throws Exception{
		return iBusService.viewAllBus();
	}

}
