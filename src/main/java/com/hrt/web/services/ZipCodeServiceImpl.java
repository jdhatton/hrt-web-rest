package com.hrt.web.services;

import java.util.Set;

import org.skife.jdbi.v2.sqlobject.Transaction;

import com.google.inject.Inject;
import com.hrt.data.db.beans.ZipCode;
import com.hrt.data.db.dao.ZipCodeDao;

public class ZipCodeServiceImpl implements ZipCodeService {


	ZipCodeDao zipCodeDao;
	
	@Inject
	public ZipCodeServiceImpl(ZipCodeDao dao) {
		this.zipCodeDao = dao;
	}

	@Transaction
	public void addZipCode(ZipCode zip) {
		
		try {
			zipCodeDao.addZipCode(zip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Set<String> getAllZips(){
		return zipCodeDao.getAllZips();		
	}



}
