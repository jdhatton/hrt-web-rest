package com.hrt.data.db.dao.impl;

import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.StudentBehavior;
import com.hrt.data.db.dao.StudentBehaviorDao;
import com.hrt.data.db.dao.StudentBehaviors;
import com.hrt.data.db.jdbi.DAO;

public class StudentBehaviorDaoImpl extends DAO implements StudentBehaviorDao {

	StudentBehaviorDao dao;
	
	@Inject
	public StudentBehaviorDaoImpl(StudentBehaviorDao dao) {
		this.dao = dao;
	}

	public List<StudentBehavior> findAll() {
		StudentBehaviors all = DAO.getDBI().onDemand(StudentBehaviors.class);
		return all.findAll();
	}

	public StudentBehavior findById(long Id) {
		StudentBehaviors dao = DAO.getDBI().onDemand(StudentBehaviors.class);
		return dao.findById(Id);
	}

	public long add(StudentBehavior obj) {
		StudentBehaviors one = DAO.getDBI().onDemand(StudentBehaviors.class);
		return one.insert(obj);
	}

}
