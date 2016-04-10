package com.hrt.data.db.dao.impl;

import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.Classroom;
import com.hrt.data.db.beans.User;
import com.hrt.data.db.dao.ClassroomDao;
import com.hrt.data.db.dao.Classrooms;
import com.hrt.data.db.dao.DAO;
import com.hrt.data.db.dao.Users;

public class ClassroomDaoImpl extends DAO implements ClassroomDao {

	
	ClassroomDao dao;
	
	@Inject
	public ClassroomDaoImpl(ClassroomDao dao) {
		this.dao = dao;		
	}

	public List<Classroom> findAll() {
		Classrooms all = DAO.getDBI().onDemand(Classrooms.class);
		return all.findAll();	
	}

	public Classroom findById(long Id) {
		Classrooms dao = DAO.getDBI().onDemand(Classrooms.class);
		return dao.findById(Id);
	}

	public long add(Classroom user) {
		Classrooms one = DAO.getDBI().onDemand(Classrooms.class);
		return one.insert(user);
	}

}
