package com.hrt.web.resources.client;

public class AddStudentDto {

//	{
//		  "id" : 4,
//		  "paid" : 0,
//		  "schoolGrade" : 0,
//		  "firstName" : "Chester HappyDick",
//		  "registered" : 0,
//		  "teacherId" : "152",
//		  "behavior" : "hands to self",
//		  "deleted" : false,
//		  "role" : 2,
//		  "zipCode" : 0,
//		  "status" : 0,
//		  "studentIdNumber" : "121212"
//	}
	
	  String id;
	  String paid;
	  String schoolGrade;
	  String firstName;
	  String registered;
	  String teacherId;
	  String behavior;
	  String deleted;
	  String role;
	  String zipCode;
	  String status;
	  String studentIdNumber;
	
	public AddStudentDto() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(String schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentIdNumber() {
		return studentIdNumber;
	}

	public void setStudentIdNumber(String studentIdNumber) {
		this.studentIdNumber = studentIdNumber;
	}

	@Override
	public String toString() {
		return "AddStudentDto [id=" + id + ", paid=" + paid + ", schoolGrade=" + schoolGrade + ", firstName="
				+ firstName + ", registered=" + registered + ", teacherId=" + teacherId + ", behavior=" + behavior
				+ ", deleted=" + deleted + ", role=" + role + ", zipCode=" + zipCode + ", status=" + status
				+ ", studentIdNumber=" + studentIdNumber + "]";
	}
	
	

	
}
