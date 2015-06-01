package com.hrt.data.db.dao;

import java.util.Set;

import com.hrt.data.db.beans.ZipCode;

public class ZipCodeDaoImpl extends DAO implements ZipCodeDao {

	public ZipCodeDaoImpl() {
	}

	public void addZipCode(ZipCode zipCode) {
		ZipCodes dao = DAO.getDBI().onDemand(ZipCodes.class);
		dao.insert(zipCode);

	}
	
	public Set<String> getAllZips() {
		ZipCodes dao = DAO.getDBI().onDemand(ZipCodes.class);
		return dao.getAll();
	}
	
 

}
