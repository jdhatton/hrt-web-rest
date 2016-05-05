package com.hrt.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.ApplicationConfiguration;
import com.hrt.data.db.beans.Device;
import com.hrt.data.db.dao.ApplicationConfigurationDao;
import com.hrt.data.db.dao.DeviceDao;
import com.hrt.data.db.dao.UserDao;
import com.hrt.modules.aws.sns.AmazonSNSPublisher;
import com.hrt.modules.dto.AwsConfiguration;
import com.hrt.web.services.DeviceNotificationService;

public class DeviceNotificationServiceImpl implements DeviceNotificationService {

	DeviceDao deviceDao;
	UserDao   userDao;
	ApplicationConfigurationDao appConfDao;
	AmazonSNSPublisher snsPublisher;
	
	@Inject
	public DeviceNotificationServiceImpl(DeviceDao deviceDao, UserDao userDao, ApplicationConfigurationDao appConfDao, AmazonSNSPublisher snsPublisher) {
		this.deviceDao = deviceDao;
		this.userDao = userDao;
		this.appConfDao = appConfDao;
		this.snsPublisher = snsPublisher;
	}

	public void sendNotification(long userId, String deviceId, String message, int badge, String sound,int priority) throws Exception {
		
		AwsConfiguration awsConf = new AwsConfiguration();
		List<ApplicationConfiguration> awsConfs = appConfDao.findByPlatform("AWS");
		
		for(ApplicationConfiguration conf : awsConfs){
			if(conf.getName().equalsIgnoreCase("awsAccessKey")){ awsConf.setAwsAccessKey(conf.getValue());}
			else if(conf.getName().equalsIgnoreCase("awsSecretKey")){ awsConf.setAwsSecretKey(conf.getValue());} 
			else if(conf.getName().equalsIgnoreCase("awsAPNSCertificate")){ awsConf.setAwsAPNSCertificate(conf.getValue());} 
			else if(conf.getName().equalsIgnoreCase("awsAPNSPrivateKey")){ awsConf.setAwsAPNSPrivateKey(conf.getValue());} 
			else if(conf.getName().equalsIgnoreCase("awsSNSApplicationName")){ awsConf.setAwsSNSApplicationName(conf.getValue());} 
			else{ System.out.println("Error Loading the ApplicationConfiguration to call AWS - SNS"); }
		}
		
		System.out.println("Loaded ApplicationConfiguration to call AWS - SNS");
		
		List<String> tokens = findDeviceIdsForUser( userId);
		for(String token : tokens){
			snsPublisher.sendNotification( token, message, badge, sound, awsConf);
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
