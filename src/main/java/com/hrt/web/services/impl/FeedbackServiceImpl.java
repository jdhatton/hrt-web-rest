package com.hrt.web.services.impl;

import org.skife.jdbi.v2.sqlobject.Transaction;

import com.google.inject.Inject;
import com.hrt.data.db.dao.FeedbackDao;
import com.hrt.web.services.FeedbackService;

public class FeedbackServiceImpl implements FeedbackService {

	FeedbackDao dao;
	
	@Inject
	public FeedbackServiceImpl(FeedbackDao dao) { 
		this.dao = dao;
	}

	@Transaction
	public void processFeedback(long userId, String feedback) {
		dao.addFeedback(userId, feedback);
		
		//
		// TODO: notify admin of feedback.
		//
	}

}
