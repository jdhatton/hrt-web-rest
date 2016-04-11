package com.hrt.web.services.impl;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Transaction;

import com.google.inject.Inject;
import com.hrt.data.db.beans.Classroom;
import com.hrt.data.db.beans.ClassroomBehavior;
import com.hrt.data.db.beans.ClassroomParent;
import com.hrt.data.db.beans.ClassroomStudent;
import com.hrt.data.db.beans.StudentBehavior;
import com.hrt.data.db.dao.ClassroomBehaviorDao;
import com.hrt.data.db.dao.ClassroomDao;
import com.hrt.data.db.dao.ClassroomStudentsDao;
import com.hrt.data.db.dao.StudentBehaviorDao;
import com.hrt.web.services.ClassroomService;

public class ClassroomServiceImpl implements ClassroomService{

	ClassroomDao classroomDao;
	ClassroomStudentsDao classroomStudentDao;
	ClassroomBehaviorDao classroomBehaviorDao;
	StudentBehaviorDao studentBehaviorDao;
	
	@Inject
	public ClassroomServiceImpl(ClassroomDao classroomDao, ClassroomStudentsDao classroomStudentDao,ClassroomBehaviorDao classroomBehaviorDao, StudentBehaviorDao studentBehaviorDao ) {
		this.classroomDao = classroomDao;
		this.classroomStudentDao = classroomStudentDao;
		this.classroomBehaviorDao = classroomBehaviorDao;
		this.studentBehaviorDao = studentBehaviorDao;
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

	public List<ClassroomStudent> getAllClassroomStudents() {
		return classroomStudentDao.findAll();
	}

	public ClassroomStudent getClassroomStudent(long Id) {
		return classroomStudentDao.findById(Id);
	}

	@Transaction
	public long addClassroomStudent(ClassroomStudent classroomStudent) {
		return classroomStudentDao.add(classroomStudent);
	}

	public List<ClassroomBehavior> getAllClassroomBehaviors() {
		return classroomBehaviorDao.findAll();
	}

	public ClassroomBehavior getClassroomBehavior(long Id) {
		return classroomBehaviorDao.findById(Id);
	}

	@Transaction
	public long addClassroomBehavior(ClassroomBehavior classroomBehavior) {
		return classroomBehaviorDao.add(classroomBehavior);
	}

	public List<StudentBehavior> getAllStudentBehaviors() {
		return studentBehaviorDao.findAll();
	}

	public StudentBehavior getStudentBehavior(long Id) {
		return studentBehaviorDao.findById(Id);
	}

	@Transaction
	public long addStudentBehavior(StudentBehavior studentBehavior) {
		return studentBehaviorDao.add(studentBehavior);
	}

	public List<ClassroomParent> getAllClassroomParents() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClassroomParent getClassroomParent(long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public long addClassroomParent(ClassroomParent classroomParent) {
		// TODO Auto-generated method stub
		return 0;
	}

}
