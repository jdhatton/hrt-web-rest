package com.hrt.data.db.jdbi;

 
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;


public class Connection {
	
	
//	#
//	# JDBI Configuration
//	#
	private final String jdbi_connection_str="jdbc:mysql://69.164.202.243:3306/BMTS?user=dev&password=superj00";
//	private final String jdbi_jdbc_str= "jdbc:mysql://69.164.202.243:3306/BMTS";
//	private final String jdbi_user="dev";
//	private final String jdbi_password="dev123";


	

	private Handle h = null;
	private DBI db = null;
	
	public Connection() {
    
//		 String jdbiConnStr = Play.configuration.getProperty("jdbi.connection.str");  
//		 System.out.println(" Createing Connection to :  " + jdbiConnStr );
//	      db = new DBI(Play.configuration.getProperty("jdbi.connection.str"));	 
		
		 String jdbiConnStr = jdbi_connection_str;  
		 System.out.println(" Creating Connection to :  " + jdbiConnStr );
	      db = new DBI(jdbi_connection_str);	
	      
	}
	
	public DBI getConnection(){
		if(db == null) { db = new DBI(jdbi_connection_str); }
		return db;
	}
	
	public Handle getHandle() {
		//
		// TODO: use some form of connection pooling or something for high load?
		//
		if(db == null) { db = new DBI(jdbi_connection_str); }
					
		h = db.open();
		return h;		
	}
	
	
	

}
