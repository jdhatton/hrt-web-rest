package com.hrt.web.services.impl;

import java.util.List;

import com.google.inject.Inject;
import com.hrt.data.db.beans.Student;
import com.hrt.data.db.dao.StudentDao;
import com.hrt.data.db.dao.UserDao;
import com.hrt.web.services.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao dao;
	
	@Inject
	public StudentServiceImpl(StudentDao userDao) {
		this.dao = userDao;		
	}

	public List<Student> getAll() {
		return dao.findAll();
	}

	public Student get(long Id) {
		return dao.findById(Id);
	}

	public long add(Student student) {
		return dao.add(student);
	}

}
