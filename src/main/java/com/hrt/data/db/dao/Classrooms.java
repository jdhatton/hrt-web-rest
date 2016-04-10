package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import com.hrt.data.db.beans.Classroom;
import com.hrt.data.db.mappers.ClassroomMapper;

@RegisterMapper(ClassroomMapper.class)
public interface Classrooms  extends Transactional<Classrooms> {
	 
		//
		// TODO: add a deviceToken field to the DB <--- this comment from Users object.
		//
	    @SqlUpdate("insert into Classroom (teacherId)  values (:teacherId )")
	    @GetGeneratedKeys
	    long insert(@BindBean Classroom classroom);
	    
	    @SqlQuery("select id, teacherId from Classroom where teacherId = :id")
	    Classroom findById(@Bind("id") long id);
	    
	    @SqlQuery("select * from Classroom ")
	    List<Classroom> findAll();
	    
}