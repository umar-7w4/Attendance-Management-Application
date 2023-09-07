package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.repository.IFeedBackRepository;

@Service("IFeedBackService")
public class IFeedBackServiceImpl implements IFeedBackService{
	
	@Autowired
	IFeedBackRepository iFeedBackRepository;

	@Override
	public FeedBack addFeedBack(FeedBack feedback) throws Exception {
		iFeedBackRepository.saveAndFlush(feedback);
		return feedback;
	}

	@Override
	public FeedBack updateFeedBack(FeedBack feedback) throws Exception {
		FeedBack  bean = null;
		try {
			bean = iFeedBackRepository.findById(feedback.getFeedBackId()).get();
		}
		catch(Exception e) {
			throw new Exception("FeedBack details not found!");
		}
		iFeedBackRepository.saveAndFlush(feedback);
		return bean;
	}

	@Override
	public FeedBack viewFeedBack(int feedbackId) throws Exception {
		FeedBack  bean = null;
		try {
			bean = iFeedBackRepository.findById(feedbackId).get();
		}
		catch(Exception e) {
			throw new Exception("FeedBack details not found!");
		}
		return bean;
	}

	@Override
	public List<FeedBack> viewAllFeedBacks() throws Exception {
		return iFeedBackRepository.findAll();
	}
	
	

}
