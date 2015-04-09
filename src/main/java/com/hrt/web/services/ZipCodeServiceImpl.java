package com.hrt.web.services;

import com.google.inject.Inject;
import com.hrt.data.db.beans.ZipCode;
import com.hrt.data.db.dao.ZipCodeDao;

public class ZipCodeServiceImpl implements ZipCodeService {


	ZipCodeDao zipCodeDao;
	
	@Inject
	public ZipCodeServiceImpl(ZipCodeDao dao) {
		this.zipCodeDao = dao;
	}

	public void addZipCode(ZipCode zip) {
		
		try {
			zipCodeDao.addZipCode(zip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
