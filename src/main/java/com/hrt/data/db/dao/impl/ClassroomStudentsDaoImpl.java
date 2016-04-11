package com.hrt.data.db.dao.impl;

import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.ClassroomStudent;
import com.hrt.data.db.dao.ClassroomStudents;
import com.hrt.data.db.dao.ClassroomStudentsDao;
import com.hrt.data.db.jdbi.DAO;

public class ClassroomStudentsDaoImpl extends DAO implements ClassroomStudentsDao {

	ClassroomStudentsDao dao;

	@Inject
	public ClassroomStudentsDaoImpl(ClassroomStudentsDao dao) {
		this.dao = dao;
	}

	public List<ClassroomStudent> findAll() {
		ClassroomStudents all = DAO.getDBI().onDemand(ClassroomStudents.class);
		return all.findAll();
	}

	public ClassroomStudent findById(long Id) {
		ClassroomStudents dao = DAO.getDBI().onDemand(ClassroomStudents.class);
		return dao.findById(Id);
	}

	public long add(ClassroomStudent student) {
		ClassroomStudents one = DAO.getDBI().onDemand(ClassroomStudents.class);
		return one.insert(student);
	}

}
