package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.District;

/**
 * Class to map the District object to the table.
 * @author jdhatton
 *
 */
public class DistrictMapper implements ResultSetMapper<District> {

	public District map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return new District(r.getLong("id"), 
				r.getString("name"),
				r.getString("address"), 
				r.getString("city"),
				r.getString("state"), 
				r.getString("zip"),
				r.getString("county"), 
				r.getString("phone"),
				r.getString("numberOfStudents"), 
				r.getString("numberOfSchools"),
				r.getString("fullDetailURL"), 
				r.getString("distance"));
	}

}