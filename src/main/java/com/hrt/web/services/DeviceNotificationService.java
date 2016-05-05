package com.hrt.web.services;

import java.util.List;

public interface DeviceNotificationService {

	public void sendNotification(long userId, String deviceId, String message, int badge, String sound, int priority) throws Exception;
	
	public List<String> findDeviceIdsForUser(long userId);
	
}
