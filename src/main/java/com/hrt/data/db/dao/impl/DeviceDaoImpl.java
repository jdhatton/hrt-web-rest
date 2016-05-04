package com.hrt.data.db.dao.impl;

import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.Device;
import com.hrt.data.db.dao.Classrooms;
import com.hrt.data.db.dao.DeviceDao;
import com.hrt.data.db.dao.Devices;
import com.hrt.data.db.jdbi.DAO;

public class DeviceDaoImpl extends DAO implements DeviceDao {

	DeviceDao dao;
	
	@Inject
	public DeviceDaoImpl(DeviceDao dao) {
		this.dao = dao;		
	}

	public List<Device> getAll() {
		Devices all = DAO.getDBI().onDemand(Devices.class);
		return all.findAll();	
	}

	public Device get(long Id) {
		Devices dao = DAO.getDBI().onDemand(Devices.class);
		return dao.findById(Id);
	}

	public List<Device> getByUserId(long userId) {
		Devices dao = DAO.getDBI().onDemand(Devices.class);
		return dao.findByUserId(userId);
	}

	public long add(Device device) {
		Devices one = DAO.getDBI().onDemand(Devices.class);
		return one.insert(device);
	}

}
