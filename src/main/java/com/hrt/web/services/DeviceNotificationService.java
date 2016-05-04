package com.hrt.web.services;

import java.util.List;

public interface DeviceNotificationService {

	public void sendNotification(long userId, String deviceId, String message, String badge, String sound, int priority);
	
	public List<String> findDeviceIdsForUser(long userId);
	
}
