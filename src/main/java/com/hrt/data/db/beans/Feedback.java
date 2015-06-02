package com.hrt.data.db.beans;


public class Feedback {

	private long Id;
	private long userId;
	private String comment;
	
	public Feedback(){}
	
	
	public Feedback(long userId,String feedback ) {
		 this.userId = userId;
		 this.comment = feedback;
	}
	
	public Feedback(long id, long userId,String feedback ) {
		this.Id=id;
		 this.userId = userId;
		 this.comment = feedback;
	}

	public Feedback(String userId,String feedback ) {
		this.userId = Long.getLong(userId);
		this.comment = feedback;
	}

	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


 
	
}
