package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.ClassroomBehavior;

public interface ClassroomBehaviorDao {

	public List<ClassroomBehavior> findAll() ;
	
	public ClassroomBehavior findById(long Id);
	
	public long add(ClassroomBehavior obj) ;
}
