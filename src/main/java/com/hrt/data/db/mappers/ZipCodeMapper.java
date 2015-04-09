package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.District;
import com.hrt.data.db.beans.ZipCode;

public class ZipCodeMapper  implements ResultSetMapper<ZipCode> {

	public ZipCodeMapper() { }
	
	public ZipCode map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return new ZipCode(r.getLong("id"), 
				r.getString("zipCode"),
				r.getString("zipCodeType"), 
				r.getString("city"),
				r.getString("state"), 
				r.getString("lat"),
				r.getString("lon"), 
				r.getString("location"),
				r.getString("decommisioned"), 
				r.getString("estimatedPopulation"));
	}

}
