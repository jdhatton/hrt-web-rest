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

	public ApplicationConfiguration findById(long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationConfiguration findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
