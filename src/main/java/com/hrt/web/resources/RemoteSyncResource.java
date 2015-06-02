/**
 * 
 */
package com.hrt.web.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.hrt.data.db.beans.User;
import com.hrt.web.services.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/remoteSync")
@Api("/remoteSync")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RemoteSyncResource extends JsonResource {

	final static Logger logger = LoggerFactory.getLogger(RemoteSyncResource.class);
	private final AtomicLong counter;
	private final UserService service;
	
	@Inject
	public RemoteSyncResource (UserService service ) {
		this.counter = new AtomicLong();
		this.service = service;
	}
	
	@GET
	@ApiOperation("sayHi")
	@Timed
	public String sayHi() {	
		return "Connected";
	}

	@POST
	@ApiOperation("comments")
	@Timed
	@Path("/comments")
	public Response syncComments( String strJson) {

		logger.debug(" RemoteSyncResource::syncComments()  :  strJson  =  " + strJson);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@POST
	@Timed
	@ApiOperation("behaviors")
	@Path("/behaviors")
	public Response syncBehaviors( String strJson) {

		logger.debug(" RemoteSyncResource::syncBehaviors()  :  strJson  =  " + strJson);
		
		return Response.status(Response.Status.OK).build();
	}
	
	
	@POST
	@ApiOperation("all")
	@Timed
	@Path("/all")
	public Response syncAll( String strJson) {

		logger.debug(" RemoteSyncResource::syncAll()  :  strJson  =  " + strJson);
		
		return Response.status(Response.Status.OK).build();
	}
	
	
	@POST
	@ApiOperation("addStudent")
	@Timed
	@Path("/addStudent/")
	public Response addStudent( String strJson) {

		
//		  strJson  =  {
//				  "status" : 0,
//				  "firstName" : "Simbad Great",
//				  "id" : 3,
//				  "role" : 2,
//				  "registered" : 0,
//				  "studentIdNumber" : "12KK34KK56",
//				  "paid" : 0,
//				  "schoolGrade" : 0,
//				  "zipCode" : 0,
//				  "teacherId" : "4"
//				}
		
		
		logger.debug(" RemoteSyncResource::addStudent()  :  strJson  =  " + strJson);
		
		return Response.status(Response.Status.OK).build();
	}
	
}
