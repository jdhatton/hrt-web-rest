package com.hrt.data.db.beans;

public class District {

	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String county;
	private String phone;
	private String numStudents;
	private String numSchools;
	private String htmlLink;
	private String distance;
	
	public District() {
		
	}

	public District(String name, String address, String city, String state,
			String zip, String county, String phone, String numStudents,
			String numSchools, String link, String distance) {
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

	public String getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(String numStudents) {
		this.numStudents = numStudents;
	}

	public String getNumSchools() {
		return numSchools;
	}

	public void setNumSchools(String numSchools) {
		this.numSchools = numSchools;
	}

	public String getHtmlLink() {
		return htmlLink;
	}

	public void setHtmlLink(String htmlLink) {
		this.htmlLink = htmlLink;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "District [name=" + name + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", county="
				+ county + ", phone=" + phone + ", numStudents=" + numStudents
				+ ", numSchools=" + numSchools + ", htmlLink=" + htmlLink
				+ ", distance=" + distance + "]";
	}
	
	

}
