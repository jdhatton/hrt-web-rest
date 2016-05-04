package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.ClassroomStudent;
import com.hrt.data.db.beans.StudentBehavior;

public class ClassroomStudentMapper implements ResultSetMapper<ClassroomStudent> {

	public ClassroomStudent map(int arg0, ResultSet r, StatementContext arg2) throws SQLException {
		return  new ClassroomStudent(r.getLong("id"), 
				r.getLong("classroomId"), 
				r.getLong("studentId"));
	}

}
