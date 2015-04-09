package com.hrt.data.db.beans;

public class ZipCode {

	private long id;
	private String zipCode;
	private String zipCodeType;
	private String city;
	private String state;
	private String lat;
	private String lon;
	private String location;
	private String decommisioned;
	private String estimatedPopulation;
	
	public ZipCode() {}

	
	
	public ZipCode(String zipCode, String zipCodeType, String city, String state) {
		super();
		this.zipCode = zipCode;
		this.zipCodeType = zipCodeType;
		this.city = city;
		this.state = state;
	}



	public ZipCode(String zipCode, String zipCodeType, String city,
			String state, String lat, String lon, String location,
			String decommisioned, String estimatedPopulation) {
		super();
		this.zipCode = zipCode;
		this.zipCodeType = zipCodeType;
		this.city = city;
		this.state = state;
		this.lat = lat;
		this.lon = lon;
		this.location = location;
		this.decommisioned = decommisioned;
		this.estimatedPopulation = estimatedPopulation;
	}



	public ZipCode(long id,String zipCode, String zipCodeType, String city,
			String state, String lat, String lon, String location,
			String decommisioned, String estimatedPopulation) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.zipCodeType = zipCodeType;
		this.city = city;
		this.state = state;
		this.lat = lat;
		this.lon = lon;
		this.location = location;
		this.decommisioned = decommisioned;
		this.estimatedPopulation = estimatedPopulation;
	}



	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCodeType() {
		return zipCodeType;
	}

	public void setZipCodeType(String zipCodeType) {
		this.zipCodeType = zipCodeType;
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

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDecommisioned() {
		return decommisioned;
	}

	public void setDecommisioned(String decommisioned) {
		this.decommisioned = decommisioned;
	}

	public String getEstimatedPopulation() {
		return estimatedPopulation;
	}

	public void setEstimatedPopulation(String estimatedPopulation) {
		this.estimatedPopulation = estimatedPopulation;
	}



	@Override
	public String toString() {
		return "ZipCode [zipCode=" + zipCode + ", zipCodeType=" + zipCodeType
				+ ", city=" + city + ", state=" + state + ", lat=" + lat
				+ ", lon=" + lon + ", location=" + location
				+ ", decommisioned=" + decommisioned + ", estimatedPopulation="
				+ estimatedPopulation + "]";
	}

	
}
