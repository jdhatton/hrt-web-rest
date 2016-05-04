package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.Device;

public interface DeviceService {

	public List<Device> getAll() ;
	
	public Device get( long Id);
	
	public List<Device> getByUserId( long Id);
	
	public long add(Device device);
	
	// need an UPDATE
}
