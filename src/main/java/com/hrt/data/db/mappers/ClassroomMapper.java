package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.Classroom;

public class ClassroomMapper implements ResultSetMapper<Classroom> {

	public ClassroomMapper() {
	}

	public Classroom map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Classroom(r.getLong("id"), r.getLong("teacherId"));
	}
}