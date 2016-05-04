package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.ApplicationConfiguration;

public interface ApplicationConfigurationDao {

	public List<ApplicationConfiguration> findAll() ;
	
	public ApplicationConfiguration findById(long Id);
	
	public ApplicationConfiguration findByName(String name);
	
	public List<ApplicationConfiguration> findByPlatform(String platform) ;
}
