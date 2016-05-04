package com.hrt.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.Device;
import com.hrt.data.db.dao.DeviceDao;
import com.hrt.data.db.dao.UserDao;
import com.hrt.web.services.DeviceNotificationService;

public class DeviceNotificationServiceImpl implements DeviceNotificationService {

	DeviceDao deviceDao;
	UserDao   userDao;
	
	@Inject
	public DeviceNotificationServiceImpl(DeviceDao deviceDao, UserDao   userDao) {
		this.deviceDao = deviceDao;
		this.userDao = userDao;
	}

	public void sendNotification(long userId, String deviceId, String message, String badge, String sound,int priority) {
		 
		List<String> tokens = findDeviceIdsForUser( userId);
		for(String token : tokens){
			
		}
		
	}

	public List<String> findDeviceIdsForUser(long userId) {
		
		List<Device> devices = deviceDao.getByUserId(userId);
		List<String> deviceIds = new ArrayList<String>();

		for(Device device : devices){
			deviceIds.add(device.getDeviceToken());
		}
		
		return deviceIds;
	}

}
