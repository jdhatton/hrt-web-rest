package com.hrt.data.db.dao.impl;

import java.util.List;

import com.hrt.data.db.beans.Student;
import com.hrt.data.db.dao.DAO;
import com.hrt.data.db.dao.StudentDao;
import com.hrt.data.db.dao.Students;

public class StudentDaoImpl extends DAO implements StudentDao {

	public StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Student> findAll() {
		Students all = DAO.getDBI().onDemand(Students.class);
		return all.findAll();
	}

	public Student findById(long Id) {
		Students dao = DAO.getDBI().onDemand(Students.class);
		return dao.findById(Id);
	}

	public long add(Student user) {
		Students one = DAO.getDBI().onDemand(Students.class);
		return one.insert(user);
	}

	public void update(Student user) {

	}

}
