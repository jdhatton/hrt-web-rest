package com.hrt.web.resources.client;

public class StudentBehaviorDto {

	String statusComment = "";
	String createdDate = "";
	String statusId = "";
	String studentId = "";
	String teacherId = "";

	public StudentBehaviorDto() {
	}

	public StudentBehaviorDto(String statusComment, String createdDate, String statusId, String studentId,
			String teacherId) {
		super();
		this.statusComment = statusComment;
		this.createdDate = createdDate;
		this.statusId = statusId;
		this.studentId = studentId;
		this.teacherId = teacherId;
	}

	public String getStatusComment() {
		return statusComment;
	}

	public void setStatusComment(String statusComment) {
		this.statusComment = statusComment;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "StudentBehaviorDto [statusComment=" + statusComment + ", createdDate=" + createdDate + ", statusId="
				+ statusId + ", studentId=" + studentId + ", teacherId=" + teacherId + "]";
	}
	
	

}
