package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.Student;

public interface StudentDao {


	public List<Student> findAll() ;
	
	public Student findById(long Id);
	
	public long add(Student user) ;

	public void update(Student user);
}
