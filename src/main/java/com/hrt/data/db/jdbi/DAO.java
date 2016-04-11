package com.hrt.data.db.jdbi;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

public abstract class DAO {

	protected static DBI db;
	protected static Handle h;
	private static Connection dbiConnection;
	
	static{
		if(dbiConnection == null){
			dbiConnection = new Connection();
			db = dbiConnection.getConnection();
			h = dbiConnection.getHandle();			
		}
	}
		
	protected static DBI getDBI(){
		return db;
	}
	
}
