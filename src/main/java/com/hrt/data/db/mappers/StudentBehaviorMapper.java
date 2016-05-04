package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.StudentBehavior;

public class StudentBehaviorMapper implements ResultSetMapper<StudentBehavior> {

	public StudentBehavior map(int arg0, ResultSet r, StatementContext arg2) throws SQLException {
				
		return  new StudentBehavior(r.getLong("id"),
				r.getLong("statusId"), 
				r.getLong("studentId"), 
				r.getLong("teacherId"),
				r.getLong("classRoomId"), 
				r.getString("behavior"), 
				r.getString("logged"),
				r.getString("status"),
				r.getString("comment"));
		 
	}
}
