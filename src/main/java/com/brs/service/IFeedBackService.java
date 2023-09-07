package com.brs.service;

import java.util.List;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;

public interface IFeedBackService {

	public FeedBack addFeedBack(FeedBack feedback) throws Exception;
	public FeedBack updateFeedBack(FeedBack feedback) throws Exception;
	public FeedBack viewFeedBack(int feedbackId) throws Exception;
	public List<FeedBack> viewAllFeedBacks()throws Exception;
}
