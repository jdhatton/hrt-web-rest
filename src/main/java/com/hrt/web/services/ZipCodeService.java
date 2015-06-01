package com.hrt.web.services;

import java.util.Set;

import com.hrt.data.db.beans.ZipCode;

public interface ZipCodeService {

	public void addZipCode(ZipCode zip);
	
	public Set<String> getAllZips();
}
