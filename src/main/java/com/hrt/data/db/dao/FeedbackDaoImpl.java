package com.hrt.data.db.dao;

public class FeedbackDaoImpl implements FeedbackDao {

	public FeedbackDaoImpl() { }

	public void addFeedback(long userId, String feedback) {
		Feedbacks dao = DAO.getDBI().onDemand(Feedbacks.class);
		dao.insert(userId, feedback);
	}

}
