package com.hrt.data.db.dao;

import com.hrt.data.db.beans.ZipCode;

public class ZipCodeDaoImpl extends DAO implements ZipCodeDao {

	public ZipCodeDaoImpl() {
	}

	public void addZipCode(ZipCode zipCode) {
		ZipCodes dao = DAO.getDBI().onDemand(ZipCodes.class);
		dao.insert(zipCode);

	}
	
 

}
