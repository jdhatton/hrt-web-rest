package com.hrt.web.services.impl;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Transaction;

import com.google.inject.Inject;
import com.hrt.data.db.beans.Classroom;
import com.hrt.data.db.dao.ClassroomDao;
import com.hrt.web.services.ClassroomService;

public class ClassroomServiceImpl implements ClassroomService{

	ClassroomDao classroomDao;
	
	@Inject
	public ClassroomServiceImpl(ClassroomDao classroomDao) {
		this.classroomDao = classroomDao;		
	}
	
	public List<Classroom> getAllClassrooms() {			
		return classroomDao.findAll();		
	}
	
	public Classroom getClassroom( long Id) {		
		return classroomDao.findById(Id);		
	}

	@Transaction
	public long addClassroom(Classroom classroom) {
		return classroomDao.add(classroom);
		
	}

}
