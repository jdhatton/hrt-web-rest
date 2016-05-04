package com.hrt.data.db.beans;

public class Device {

	long id;
	String platform;
	String device; 
	String deviceToken;
	String awsEndPointArn;
	long userId;
	Boolean enabled;
	Boolean valid;
	String lastUpdated;
			
	public Device() { }

	public Device(long id, String platform, String device, String deviceToken, String awsEndPointArn, long userId,
			Boolean enabled, Boolean valid, String lastUpdated) {
		super();
		this.id = id;
		this.platform = platform;
		this.device = device;
		this.deviceToken = deviceToken;
		this.awsEndPointArn = awsEndPointArn;
		this.userId = userId;
		this.enabled = enabled;
		this.valid = valid;
		this.lastUpdated = lastUpdated;
	}
	
	

	public Device(long id, String platform, String device, String deviceToken, String awsEndPointArn, long userId,
			String lastUpdated) {
		super();
		this.id = id;
		this.platform = platform;
		this.device = device;
		this.deviceToken = deviceToken;
		this.awsEndPointArn = awsEndPointArn;
		this.userId = userId;
		this.lastUpdated = lastUpdated;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getAwsEndPointArn() {
		return awsEndPointArn;
	}

	public void setAwsEndPointArn(String awsEndPointArn) {
		this.awsEndPointArn = awsEndPointArn;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

}
