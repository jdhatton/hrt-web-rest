package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.Classroom;
import com.hrt.data.db.beans.ClassroomBehavior;
import com.hrt.data.db.beans.ClassroomParent;
import com.hrt.data.db.beans.ClassroomStudent;
import com.hrt.data.db.beans.StudentBehavior;

public interface ClassroomService {

	/**
	 * The top level Classroom. 
	 */
	public List<Classroom> getAllClassrooms() ;
	public Classroom getClassroom( long Id);
	public long addClassroom(Classroom classroom);
	/**
	 * The association table for students in a classroom. 
	 */
	public List<ClassroomStudent> getAllClassroomStudents() ;
	public ClassroomStudent getClassroomStudent( long Id);
	public long addClassroomStudent(ClassroomStudent classroomStudent);
	/**
	 * NOT Used right now. This needs to be factored out. 
	 */
	public List<ClassroomBehavior> getAllClassroomBehaviors() ;
	public ClassroomBehavior getClassroomBehavior( long Id);
	public long addClassroomBehavior(ClassroomBehavior classroomBehavior);
	/**
	 * The table used to store the logged behaviors for a student. 
	 * This data can be associated using the studentId-teacherId columns. 
	 */
	public List<StudentBehavior> getAllStudentBehaviors() ;
	public StudentBehavior getStudentBehavior( long Id);
	public long addStudentBehavior(StudentBehavior studentBehavior);
	/**
	 * The association table for parents of students in a classroom. 
	 */
	public List<ClassroomParent> getAllClassroomParents() ;
	public ClassroomParent getClassroomParent( long Id);
	public long addClassroomParent(ClassroomParent classroomParent);
}
