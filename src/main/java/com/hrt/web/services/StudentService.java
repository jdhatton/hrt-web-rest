package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.Student;

public interface StudentService {

	public List<Student> getAll() ;
	
	public Student get( long Id);
	
	public long add(Student student);
}
