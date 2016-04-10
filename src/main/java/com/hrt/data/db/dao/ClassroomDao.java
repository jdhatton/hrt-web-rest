package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.Classroom;

public interface ClassroomDao {

	public List<Classroom> findAll() ;
	
	public Classroom findById(long Id);
	
	public long add(Classroom user) ;
}
