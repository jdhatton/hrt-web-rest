package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import com.hrt.data.db.beans.Student;
import com.hrt.data.db.mappers.StudentMapper;

@RegisterMapper(StudentMapper.class)
public interface Students extends Transactional<Students>{
	 
		//
		// TODO: add a deviceToken field to the DB <--- this comment from Users object.
		//
	    @SqlUpdate("insert into Student ( firstName, lastName, status, registered, role, zipCode, email, gender, paid, password, phone ) "
	    		+  "values ( :firstName ,:lastName ,:status ,:registered ,:role ,:zipCode ,:email ,:gender , :paid, :password, :phone   )")
	    @GetGeneratedKeys
	    long insert(@BindBean Student user);
	    
	    @SqlQuery("select id, email from Student where id = :id")
	    Student findById(@Bind("id") long id);
	    
	    @SqlQuery("select * from Student ")
	    List<Student> findAll();
	    
}