package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import com.hrt.data.db.beans.ClassroomStudent;

public interface ClassroomStudents {

    @SqlUpdate("insert into ClassroomStudents (classRoomId, teacherId)  values (:classroomId , :teacherId )")
    @GetGeneratedKeys
    long insert(@BindBean ClassroomStudent student);
    
    @SqlQuery("select id, classroomId, teacherId from ClassroomStudents where teacherId = :id")
    ClassroomStudent findById(@Bind("id") long id);
    
    @SqlQuery("select * from ClassroomStudents ")
    List<ClassroomStudent> findAll();
}
