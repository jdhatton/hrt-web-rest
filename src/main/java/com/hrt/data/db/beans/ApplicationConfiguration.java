package com.hrt.data.db.beans;

public class ApplicationConfiguration {

	long id;
	String name;
	String value;
	Boolean enabled;
	
	public ApplicationConfiguration() { }

	public ApplicationConfiguration(long id, String name, String value, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.enabled = enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
