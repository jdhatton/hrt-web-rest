package com.hrt.data.db.beans;

public class District {

	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String county;
	private String phone;
	private long numStudents;
	private long numSchools;
	private String htmlLink;
	
	public District() {
		
	}

	public District(String name, String address, String city, String state,
			String zip, String county, String phone, long numStudents,
			long numSchools, String link) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.county = county;
		this.phone = phone;
		this.numStudents = numStudents;
		this.numSchools = numSchools;
		this.htmlLink = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(long numStudents) {
		this.numStudents = numStudents;
	}

	public long getNumSchools() {
		return numSchools;
	}

	public void setNumSchools(long numSchools) {
		this.numSchools = numSchools;
	}

	public String getHtmlLink() {
		return htmlLink;
	}

	public void setHtmlLink(String htmlLink) {
		this.htmlLink = htmlLink;
	}
	
	

}
