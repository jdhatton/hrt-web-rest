package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import com.hrt.data.db.beans.StudentBehavior;
import com.hrt.data.db.mappers.StudentBehaviorMapper;

@RegisterMapper(StudentBehaviorMapper.class)
public interface StudentBehaviors extends Transactional<Classrooms> {
	
    @SqlUpdate("insert into StudentBehavior (teacherId)  values (:teacherId )")
    @GetGeneratedKeys
    long insert(@BindBean StudentBehavior classroom);
    
    @SqlQuery("select id, teacherId from StudentBehavior where id = :id")
    StudentBehavior findById(@Bind("id") long id);
    
    @SqlQuery("select * from StudentBehavior ")
    List<StudentBehavior> findAll();

}
