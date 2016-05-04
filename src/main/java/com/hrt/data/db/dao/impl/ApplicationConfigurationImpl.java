package com.hrt.data.db.dao.impl;

import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.ApplicationConfiguration;
import com.hrt.data.db.dao.ApplicationConfigurationDao;
import com.hrt.data.db.dao.ApplicationConfigurations;
import com.hrt.data.db.jdbi.DAO;

public class ApplicationConfigurationImpl extends DAO implements ApplicationConfigurationDao {

	ApplicationConfigurationDao dao;
	
	@Inject
	public ApplicationConfigurationImpl(ApplicationConfigurationDao dao) {
		this.dao = dao;	
	}

	public List<ApplicationConfiguration> findAll() {
		ApplicationConfigurations all = DAO.getDBI().onDemand(ApplicationConfigurations.class);
		return all.findAll();	
	}

	public ApplicationConfiguration findById(long id) {
		ApplicationConfigurations all = DAO.getDBI().onDemand(ApplicationConfigurations.class);
		return all.findById(id);	
	}

	public ApplicationConfiguration findByName(String name) {
		ApplicationConfigurations all = DAO.getDBI().onDemand(ApplicationConfigurations.class);
		return all.findByName(name);	
	}

	public List<ApplicationConfiguration> findByPlatform(String platform) {
		ApplicationConfigurations all = DAO.getDBI().onDemand(ApplicationConfigurations.class);
		return all.findByPlatform(platform);	
	}

}
