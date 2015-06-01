package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.District;

public interface DistrictDao {

	public List<District> findAll() ;
	
	public District findById(long Id);
	
	public void addDistrict(District district) ;

	public void updateDistrict(District district);

	public List<District> findByZip(String zip);
	
}
