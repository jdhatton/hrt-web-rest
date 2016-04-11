package com.hrt.data.db.beans;

public class ClassroomStudent {

	long id;
	long classroomId;
	long studentId;
	
	public ClassroomStudent() { }

	public ClassroomStudent(long classroomId, long studentId) {
		super();
		this.classroomId = classroomId;
		this.studentId = studentId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	

}
