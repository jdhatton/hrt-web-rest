package com.hrt.data.db.beans;

import com.hrt.web.resources.client.StudentBehaviorDto;

public class StudentBehavior {

	private long Id;
	private long statusId;
	private long studentId;
	private long teacherId;
	private long classRoomId;
	private String behavior;
	private String logged;
	private String status;
	private String comment;

	public StudentBehavior() { }
	
	public StudentBehavior(long id, long statusId, long studentId, long teacherId, long classRoomId, String behavior,
			String logged, String status, String comment) {
		super();
		Id = id;
		this.statusId = statusId;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.classRoomId = classRoomId;
		this.behavior = behavior;
		this.logged = logged;
		this.status = status;
		this.comment = comment;
	}

	public StudentBehavior(StudentBehaviorDto dto){
		this.statusId = new Long(dto.getStatusId());
		this.studentId = new Long(dto.getStudentId());
		this.teacherId = new Long(dto.getTeacherId());
		this.comment = dto.getStatusComment();
		this.logged = dto.getCreatedDate();
	}
	
	public StudentBehavior(long statusId, long studentId, long teacherId, String behavior, String logged, String status,
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
			String logged, String status, String comment) {
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

	public String getLogged() {
		return logged;
	}

	public void setLogged(String logged) {
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
