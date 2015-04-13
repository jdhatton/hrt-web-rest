package com.hrt.web.core;

public class User extends MappedObject {

	

	private long Id;
	private String email;
	private String phone;
	private double zipCode;
	private String schoolDistrict;
	private String schoolName;
	private int schoolGrade;
	private int registered;
	private int role;
	private String firstName;
	private String lastName;
	private String gender;
	private int status;
	private int paid;
    private String deviceToken;
 
	
	public User() { }
	
	public User(long id, String email) {
		super();
		Id = id;
		this.email = email;
	}
	
	
	public User(long id, String email, String phone, double zipCode,
			String schoolDistrict, String schoolName, int schoolGrade,
			int registered, int role, String firstName, String lastName,
			String gender, int status, int paid, String deviceToken) {
		super();
		Id = id;
		this.email = email;
		this.phone = phone;
		this.zipCode = zipCode;
		this.schoolDistrict = schoolDistrict;
		this.schoolName = schoolName;
		this.schoolGrade = schoolGrade;
		this.registered = registered;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.status = status;
		this.paid = paid;
		this.deviceToken = deviceToken;
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
	public String getSchoolDistrict() {
		return schoolDistrict;
	}
	public void setSchoolDistrict(String schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getSchoolGrade() {
		return schoolGrade;
	}
	public void setSchoolGrade(int schoolGrade) {
		this.schoolGrade = schoolGrade;
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

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", email=" + email + ", phone=" + phone + ", zipCode=" + zipCode
				+ ", schoolDistrict=" + schoolDistrict + ", schoolName=" + schoolName + ", schoolGrade=" + schoolGrade
				+ ", registered=" + registered + ", role=" + role + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", status=" + status + ", paid=" + paid + ", deviceToken="
				+ deviceToken + "]";
	}
 
	
	
	
}

