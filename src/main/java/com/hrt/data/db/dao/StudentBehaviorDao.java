package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.StudentBehavior;

public interface StudentBehaviorDao {

	public List<StudentBehavior> findAll() ;
	
	public StudentBehavior findById(long Id);
	
	public long add(StudentBehavior obj) ;
}
