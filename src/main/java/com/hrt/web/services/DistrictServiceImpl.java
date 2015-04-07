/**
 * 
 */
package com.hrt.web.services;

import java.util.List;

import javax.inject.Inject;

import com.hrt.data.db.beans.District;
import com.hrt.data.db.dao.DistrictDao;
import com.hrt.data.db.dao.UserDao;

/**
 * @author jdhatton
 *
 */
public class DistrictServiceImpl implements DistrictService {

	DistrictDao districtDao;
	
	@Inject
	public DistrictServiceImpl(DistrictDao dao) {
		this.districtDao = dao;
	}

	/* (non-Javadoc)
	 * @see com.hrt.web.services.DistrictService#addDistrict(com.hrt.data.db.beans.District)
	 */
	public void addDistrict(District district) {
		
		try {
			districtDao.addDistrict(district);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public District findById(long id) {
		return districtDao.findById(id);
	}

	public List<District> findAll() {
		return districtDao.findAll();
	}

	public List<District> findByZip(String zip) {
		return districtDao.findByZip(zip);
	}
	
	

}
