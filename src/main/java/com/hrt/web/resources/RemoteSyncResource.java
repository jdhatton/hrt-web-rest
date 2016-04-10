/**
 * 
 */
package com.hrt.web.resources;

import java.io.IOException;
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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.inject.Inject;
import com.hrt.data.db.beans.Student;
import com.hrt.web.services.StudentService;
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
	private final UserService userService;
	private final StudentService studentService;
	
	@Inject
	public RemoteSyncResource (UserService userService, StudentService studentService ) {
		this.counter = new AtomicLong();
		this.userService = userService;
		this.studentService = studentService;
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
		
		//
		// TODO: we should get he TeacherId, StudentId, Behavior, and the Behavior Status
		//
		
		// 1). Insert record into the ClassroomBehaviors table.
		
		
		
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

//		behavior
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
		
		//
		// TODO: create the association to the teacher. 
		//
		
		
		String remoteUserId = null;
		Student student = null;
		long userId=0;
		try {
			logger.debug(" >> mapping to database ");
			//
			// TODO: does this map into a student? or should we have a hybrid object for this before parsing.
			//
			student = getMapper().readValue(strJson, Student.class);
			if(student != null){
			// 1). Create a Student record.
				logger.debug(" >> creating student ");
				userId = studentService.add(student);
				remoteUserId = Long.toString(userId);
				student.setRemoteId(remoteUserId);
			}
			
			
			// 1). Create record in Classroom with TeacherId
			logger.debug(" >> creating classroom ");
			
			
			// 2). Create record in ClassRoomBehaviors with TeacherId, behavior, (newly created from Student table) studentId
			
			// 3). Create a ClassroomStudent record with the newly created classroonId and studentId.
			
			
			
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
		

		
		
		
		return Response.status(Response.Status.OK).build();
	}
	
}
