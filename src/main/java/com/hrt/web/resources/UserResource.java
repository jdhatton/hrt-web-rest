package com.hrt.web.resources;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.hrt.data.db.beans.Classroom;
import com.hrt.data.db.beans.User;
import com.hrt.web.services.ClassroomService;
import com.hrt.web.services.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/registerUser")
@Api("/registerUser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource extends JsonResource{
	
	final static Logger logger = LoggerFactory.getLogger(UserResource.class);
	private final AtomicLong counter;
	private final UserService service;
	private final ClassroomService classroomService;
	
	@Inject
	public UserResource(UserService service, ClassroomService classroomService) {
		this.counter = new AtomicLong();
		this.service = service;
		this.classroomService = classroomService;
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
	 @ApiOperation("add")
	@Timed
	@Path("/add")
	public User registerUser( String userJson) {

		logger.debug(" DataSyncResource::registerUser()  :  User  =  " + userJson);
		
		/**
		  User  =  {
			  "id" : 1,
			  "schoolDistrict" : "Not Found",
			  "lastName" : "Test",
			  "firstName" : "Deedee",
			  "schoolGrade" : 4,
			  "status" : 0,
			  "registered" : 0,
			  "deviceId" : "0EF2F242-0943-49A3-8216-1CAFD684A7E3",
			  "deleted" : false,
			  "password" : "12345",
			  "role" : 0,
			  "schoolName" : "Freedom School",
			  "zipCode" : 30024,
			  "email" : "test@test.com",
			  "gender" : "M",
			  "paid" : 0
			}

		 */
		
		
		String remoteUserId = null;
		User user = null;
		long userId=0;
		try {
			logger.debug(" >> mapping to database ");
			user = getMapper().readValue(userJson, User.class);
			if(user != null){
				userId = service.addUser(user);
				remoteUserId = Long.toString(userId);
				user.setRemoteId(remoteUserId);
				
				if( remoteUserId != null){
					Classroom classroom = new Classroom(remoteUserId);
					long classRoomId = classroomService.addClassroom(classroom);
					logger.debug("Added Classroom: classRoomId = " + classRoomId);
				}
			}
		} catch (JsonParseException e) {
			logger.debug(" >> JsonParseException  :  " + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.debug(" >> JsonMappingException  :  " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.debug(" >> IOException  :  " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e ){
			logger.debug(" >> Exception  :  " + e.getMessage());
			e.printStackTrace();
		}
		
		logger.debug(" DataSyncResource::syncData()  :  User created   =  " + remoteUserId);
  
		 return user;
//		return Response.status(Response.Status.OK).build();
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
