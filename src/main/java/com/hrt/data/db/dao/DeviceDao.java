package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.Device;

public interface DeviceDao {

	public List<Device> getAll() ;
	
	public Device get( long Id);
	
	public List<Device> getByUserId( long Id);
	
	public long add(Device device);
	
	// need an UPDATE
}
