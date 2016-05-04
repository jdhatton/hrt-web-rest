package com.hrt.data.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hrt.data.db.beans.Device;

public class DeviceMapper  implements ResultSetMapper<Device> {

	public DeviceMapper() { }
	public Device map(int arg0, ResultSet r, StatementContext arg2) throws SQLException {
		
		return  new Device(r.getLong("id"), 
				r.getString("platform"), 
				r.getString("device"), 
				r.getString("deviceToken"),
				r.getString("awsEndPointArn"), 
				r.getLong("userId"), 
				r.getString("lastUpdated"));
	}

}
