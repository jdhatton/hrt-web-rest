package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.Student;

public class StudentMapper implements ResultSetMapper<Student> {
	
	public Student map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return  new Student(r.getLong("id"), r.getString("email"), 
				r.getString("phone"), 
				r.getDouble("zipCode"),
				r.getString("schoolDistrict"), 
				r.getString("schoolName"), 
				r.getInt("schoolGrade"),
				r.getInt("registered"), 
				r.getInt("role"), 
				r.getString("firstName"), 
				r.getString("lastName"),
				r.getString("gender"), 
				r.getInt("status"), 
				r.getInt("paid"), 
				//new DateTime(r.getDate("lastActivity")),
				//new DateTime(r.getDate("lastModified")), 
				"",r.getString("remoteId"),
				r.getString("password"));

		}
 
}
