package com.hrt.data.db.dao.impl;

import com.hrt.data.db.dao.DAO;
import com.hrt.data.db.dao.FeedbackDao;
import com.hrt.data.db.dao.Feedbacks;

public class FeedbackDaoImpl extends DAO implements FeedbackDao {

	public FeedbackDaoImpl() { }

	public void addFeedback(long userId, String feedback) {
		Feedbacks dao = DAO.getDBI().onDemand(Feedbacks.class);
		dao.insert(userId, feedback);
	}

}
