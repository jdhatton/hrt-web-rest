package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.ApplicationConfiguration;

public class ApplicationConfigurationMapper implements ResultSetMapper<ApplicationConfiguration> {

	public ApplicationConfigurationMapper() { }

	public ApplicationConfiguration map(int arg0, ResultSet r, StatementContext arg2) throws SQLException {
		return new ApplicationConfiguration(r.getLong("id"), r.getString("name"), r.getString("value"), r.getBoolean("enabled"));
	}
}
