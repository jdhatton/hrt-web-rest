package com.hrt.web.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.hrt.web.core.User;
import com.hrt.web.services.UserService;

@Path("/registerUser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataSyncResource {


	private final AtomicLong counter;
	private final UserService service;
	
	@Inject
	public DataSyncResource(UserService service) {
		this.counter = new AtomicLong();
		this.service = service;
	}

	@GET
	@Timed
	public String sayHi() {	
		return "Connected";
	}
 

//	@POST
//	@Timed
//	@Path("/{id}")
//	public DataSyncResponse syncData(@QueryParam("data") String data) {
//
//		System.out.println(" DataSyncResource::syncData() = " + data);
//
//		return new DataSyncResponse("SUCCESS");
//	}
 
	@POST
	@Timed
	public Response syncData( User user) {

		System.out.println("\n >>>>>>>>>    DataSyncResource::syncData() ");
		System.out.println("\n >>>>>>>>>    DataSyncResource::syncData()  :  User  =  " + user.toString() + "\n ");

 
		return Response.status(Response.Status.OK).build();
	}

//	@POST
//	@Timed
//	@Path("update/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public int updateRecord(@PathParam("id") int id, List<Entity> entities) {
//		// Do something with entities...
//		return 0;
//	}
}
