package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import com.hrt.data.db.beans.ClassroomStudent;

public interface ClassroomStudents {

    @SqlUpdate("insert into ClassRoomStudents (classRoomId, studentId)  values (:classroomId , :studentId )")
    @GetGeneratedKeys
    long insert(@BindBean ClassroomStudent student);
    
    @SqlQuery("select id, classroomId, teacherId from ClassRoomStudents where teacherId = :id")
    ClassroomStudent findById(@Bind("id") long id);
    
    @SqlQuery("select * from ClassRoomStudents ")
    List<ClassroomStudent> findAll();
}
