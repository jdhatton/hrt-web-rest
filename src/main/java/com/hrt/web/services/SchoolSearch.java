package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.District;
import com.hrt.data.db.beans.School;

public interface SchoolSearch {

	public List<District> findSchoolDistricts(String zipCode);
	
	public List<School> findSchoolsInDistrict(District schoolDistrict);

}
 
