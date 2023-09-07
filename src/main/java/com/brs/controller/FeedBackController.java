package com.brs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.service.IBusService;
import com.brs.service.IFeedBackService;

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
@RequestMapping("/brs-feedback")
public class FeedBackController {
	
	@Autowired
	IFeedBackService iFeedBackService;
	
	@PostMapping("/addFeedBack")
	public FeedBack addFeedBack(@RequestBody FeedBack feedback) throws Exception{
		return iFeedBackService.addFeedBack(feedback);
	}
	
	@PutMapping("/updateFeedBack")
	public FeedBack updateFeedBack(@RequestBody FeedBack feedback) throws Exception{
		return iFeedBackService.updateFeedBack(feedback);
	}
	
	@GetMapping("/viewFeedBack/{feedbackId}")
	public FeedBack viewFeedBack(@PathVariable int feedbackId) throws Exception{
		return iFeedBackService.viewFeedBack(feedbackId);
	}
	
	@GetMapping("/viewAllFeedBacks")
	public List<FeedBack> viewAllFeedBacks()throws Exception{
		return iFeedBackService.viewAllFeedBacks();
	}
	

}
