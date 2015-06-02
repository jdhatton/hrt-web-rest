package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.Feedback;

public class FeedbackMapper implements ResultSetMapper<Feedback> {
	
	public Feedback map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return  new Feedback(
				r.getLong("id"), 
				r.getLong("userId"), 
				r.getString("comment"));

		}
 
}