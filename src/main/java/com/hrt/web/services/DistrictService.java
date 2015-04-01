package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.District;

public interface DistrictService {

	public void addDistrict(District district);
	
	public District findById(long id);
	
	public List<District> findAll();
	
	
}
