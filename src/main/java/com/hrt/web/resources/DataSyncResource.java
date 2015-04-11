package com.hrt.web.resources;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.hrt.data.db.beans.User;
import com.hrt.web.resources.client.DataSyncResponse;

@Path("/registerUser")

public class DataSyncResource {


	private final AtomicLong counter;

	@Inject
	public DataSyncResource() {
		this.counter = new AtomicLong();
	}

	@GET
	@Timed
	public String sayHi() {	
		return "Connected";
	}
 

	@POST
	@Timed
	@Path("/{id}")
	public DataSyncResponse syncData(@QueryParam("data") String data) {

		System.out.println(" DataSyncResource::syncData() = " + data);

		return new DataSyncResponse("SUCCESS");
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Timed
	@Path("/{id}")
	public DataSyncResponse syncData(User user) {

		System.out.println(" DataSyncResource::syncData()  :  User  =  " + user);

		return new DataSyncResponse("SUCCESS");
	}

	@POST
	@Timed
	@Path("update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public int updateRecord(@PathParam("id") int id, List<Entity> entities) {
		// Do something with entities...
		return 0;
	}
}
