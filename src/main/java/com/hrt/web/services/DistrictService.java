package com.hrt.web.services;

import java.util.List;
import java.util.Set;

import com.hrt.data.db.beans.District;

public interface DistrictService {

	public void addDistrict(District district);
	
	public District findById(long id);
	
	public List<District> findByZip(String zip);
	
	public List<District> findAll();
		
}
