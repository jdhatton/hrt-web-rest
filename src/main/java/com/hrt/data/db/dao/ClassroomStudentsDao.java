package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.ClassroomStudent;

public interface ClassroomStudentsDao {

	public List<ClassroomStudent> findAll() ;
	
	public ClassroomStudent findById(long Id);
	
	public long add(ClassroomStudent user) ;
}
