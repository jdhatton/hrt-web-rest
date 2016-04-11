package com.hrt.data.db.beans;

import java.util.Date;

public class StudentBehavior {

	private long Id;
	private long statusId;
	private long studentId;
	private long teacherId;
	private long classRoomId;
	private String behavior;
	private Date logged;
	private String status;
	private String comment;

	public StudentBehavior() { }

	public StudentBehavior(long statusId, long studentId, long teacherId, String behavior, Date logged, String status,
			String comment) {
		super();
		this.statusId = statusId;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.behavior = behavior;
		this.logged = logged;
		this.status = status;
		this.comment = comment;
	}

	public StudentBehavior(long statusId, long studentId, long teacherId, long classRoomId, String behavior,
			Date logged, String status, String comment) {
		super();
		this.statusId = statusId;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.classRoomId = classRoomId;
		this.behavior = behavior;
		this.logged = logged;
		this.status = status;
		this.comment = comment;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public long getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(long classRoomId) {
		this.classRoomId = classRoomId;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public Date getLogged() {
		return logged;
	}

	public void setLogged(Date logged) {
		this.logged = logged;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
