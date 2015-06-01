package com.hrt.data.db.dao;

import java.util.Set;

import com.hrt.data.db.beans.ZipCode;

public interface ZipCodeDao {

	public void addZipCode(ZipCode zipCode);
	
	public Set<String> getAllZips();
}
