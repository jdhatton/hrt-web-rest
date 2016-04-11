package com.hrt.data.db.beans;

public class Classroom {
	
	long id;
	long teacherId;
	
	public Classroom(){}
	
	public Classroom(long id, long teacherId) {
		super();
		this.id = id;
		this.teacherId = teacherId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	
	

}
