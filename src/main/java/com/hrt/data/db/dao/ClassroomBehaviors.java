package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import com.hrt.data.db.beans.ClassroomBehavior;
import com.hrt.data.db.mappers.ClassroomBehaviorMapper;

@RegisterMapper(ClassroomBehaviorMapper.class)
public interface ClassroomBehaviors extends Transactional<Classrooms> {

    @SqlUpdate("insert into ClassroomBehaviors (teacherId)  values (:teacherId )")
    @GetGeneratedKeys
    long insert(@BindBean ClassroomBehavior classroom);
    
    @SqlQuery("select id, teacherId from ClassroomBehaviors where teacherId = :id")
    ClassroomBehavior findById(@Bind("id") long id);
    
    @SqlQuery("select * from ClassroomBehaviors ")
    List<ClassroomBehavior> findAll();
}
