package com.hrt.data.db.beans;

import com.hrt.data.db.enums.UserRole;
import com.hrt.web.resources.client.AddStudentDto;

public class Student {

	private long Id;
	private String email;
	private String phone;
	private double zipCode;
	private String studentId;
	private int registered;
	private int role;
	private String firstName;
	private String lastName;
	private String gender;
	private int status;
	private int paid;
	String remoteId;
	String deviceId; // store the provided studentId from the app here !?!
	String password;
	String deleted;
	
	
	public Student(){}
	
	public Student(AddStudentDto dto){
		
		this.deleted = "false";
		this.studentId = dto.getId();
		this.paid = 0;
		this.firstName = dto.getFirstName();
		this.deleted = dto.getDeleted();
		this.role = UserRole.STUDENT.getValue();
		this.setLastName(dto.getStudentIdNumber());  //REMOVE
		this.studentId = dto.getStudentIdNumber();
	
	}

	public Student(String email, String phone, double zipCode, String studentId, int registered, int role,
			String firstName, String lastName, int status, String remoteId, String password) {
		super();
		this.email = email;
		this.phone = phone;
		this.zipCode = zipCode;
		this.studentId = studentId;
		this.registered = registered;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.remoteId = remoteId;
		this.password = password;
	}
	
	public Student(long id, String email, String phone, double zipCode, String studentId, int registered, int role,
			String firstName, String lastName, int status, String remoteId, String password) {
		super();
		this.Id = id;
		this.email = email;
		this.phone = phone;
		this.zipCode = zipCode;
		this.studentId = studentId;
		this.registered = registered;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.remoteId = remoteId;
		this.password = password;
	}

	public Student(long id, String email, String phone, double zipCode, String studentId, int registered, int role,
			String firstName, String lastName, String gender, int status, int paid, String remoteId, String deviceId,
			String password, String deleted) {
		super();
		Id = id;
		this.email = email;
		this.phone = phone;
		this.zipCode = zipCode;
		this.studentId = studentId;
		this.registered = registered;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.status = status;
		this.paid = paid;
		this.remoteId = remoteId;
		this.deviceId = deviceId;
		this.password = password;
		this.deleted = deleted;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getZipCode() {
		return zipCode;
	}

	public void setZipCode(double zipCode) {
		this.zipCode = zipCode;
	}

	public int getRegistered() {
		return registered;
	}

	public void setRegistered(int registered) {
		this.registered = registered;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public String getRemoteId() {
		return remoteId;
	}

	public void setRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}




	public String getStudentId() {
		return studentId;
	}




	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	

}
