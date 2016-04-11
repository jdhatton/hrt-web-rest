package com.hrt.data.db.beans;

public class ClassroomParent {

	private long Id;
	private long classRoomId;
	private long studentId;
	private long parentId;
		
	public ClassroomParent() { }

	public ClassroomParent(long classRoomId, long studentId, long parentId) {
		super();
		this.classRoomId = classRoomId;
		this.studentId = studentId;
		this.parentId = parentId;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(long classRoomId) {
		this.classRoomId = classRoomId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
}
