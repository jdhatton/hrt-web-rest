package com.hrt.data.db.dao.impl;

import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.ClassroomBehavior;
import com.hrt.data.db.dao.ClassroomBehaviorDao;
import com.hrt.data.db.dao.ClassroomBehaviors;
import com.hrt.data.db.jdbi.DAO;

public class ClassroomBehaviorDaoImpl extends DAO implements ClassroomBehaviorDao {

	
	ClassroomBehaviorDao dao;
	
	@Inject
	public ClassroomBehaviorDaoImpl(ClassroomBehaviorDao dao) {
		this.dao = dao;
	}

	public List<ClassroomBehavior> findAll() {
		ClassroomBehaviors all = DAO.getDBI().onDemand(ClassroomBehaviors.class);
		return all.findAll();	
	}

	public ClassroomBehavior findById(long Id) {
		ClassroomBehaviors dao = DAO.getDBI().onDemand(ClassroomBehaviors.class);
		return dao.findById(Id);
	}

	public long add(ClassroomBehavior obj) {
		ClassroomBehaviors one = DAO.getDBI().onDemand(ClassroomBehaviors.class);
		return one.insert(obj);
	}

}
