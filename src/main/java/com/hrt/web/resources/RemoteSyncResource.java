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
import com.hrt.data.db.beans.Classroom;
import com.hrt.data.db.beans.ClassroomStudent;
import com.hrt.data.db.beans.Student;
import com.hrt.data.db.beans.StudentBehavior;
import com.hrt.web.services.ClassroomService;
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
	private final ClassroomService classroomService;

	@Inject
	public RemoteSyncResource(UserService userService, StudentService studentService,
			ClassroomService classroomService) {
		this.counter = new AtomicLong();
		this.userService = userService;
		this.studentService = studentService;
		this.classroomService = classroomService;
	}

	@GET
	@ApiOperation("sayHi")
	@Timed
	public String sayHi() {
		return "Connected";
	}

	@POST
	@ApiOperation("addStudent")
	@Timed
	@Path("/addStudent/")
	public Response addStudent(String strJson) {

		logger.debug(" RemoteSyncResource::addStudent()  :  strJson  =  " + strJson);
		
		
		/**
		 
		  DEBUG [2016-04-14 14:51:42,594] com.hrt.web.resources.RemoteSyncResource:  RemoteSyncResource::addStudent()  :  strJson  =  
		  {
			  "id" : 4,
			  "paid" : 0,
			  "schoolGrade" : 0,
			  "firstName" : "Chester HappyDick",
			  "registered" : 0,
			  "teacherId" : "152",
			  "behavior" : "hands to self",
			  "deleted" : false,
			  "role" : 2,
			  "zipCode" : 0,
			  "status" : 0,
			  "studentIdNumber" : "121212"
			}

		  
		 */
		
		
		
		

		String teacherId = "";
		String remoteUserId = null;
		Student student = null;
		long studentId = 0;
		try {
			logger.debug(" >> mapping to database ");
			//
			// TODO: does this map into a student? or should we have a hybrid
			// object for this before parsing.
			//
			student = getMapper().readValue(strJson, Student.class);

			if (student != null) {
				// 1). Create a Student record.
				logger.debug(" >> creating student ");
				studentId = studentService.add(student);
				remoteUserId = Long.toString(studentId);
				student.setRemoteId(remoteUserId);

				// 1). Get the Classroom with TeacherId
				logger.debug(" >> creating classroom ");
				Classroom classroom = classroomService.getClassroom(new Long(teacherId).longValue());

				// 2). Create a ClassroomStudent record with the newly created
				ClassroomStudent classroomStudent = new ClassroomStudent(classroom.getId(), student.getId());
				if (classroomService.addClassroomStudent(classroomStudent) < 0) {
					//
					// TODO: We had an error creating this record. Log the
					// Error.
					//
					logger.error("\n\n ERROR adding student: creating ClassroomStudent record %", strJson);
				}
			}
		} catch (JsonParseException e) {
			logger.error("Exception : % ", e);
		} catch (JsonMappingException e) {
			logger.error("Exception : % ", e);
		} catch (IOException e) {
			logger.error("IOException  :  % ", e);
		} catch (Exception e) {
			logger.error("Exception  :  % ", e);
		}

		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Timed
	@ApiOperation("behaviors")
	@Path("/behaviors")
	public Response syncBehaviors(String strJson) {

		logger.debug(" RemoteSyncResource::syncBehaviors()  :  strJson  =  " + strJson);

		//
		// TODO: Insert a new record in to the StudentBehavior table. 
		// 
		// ASSUMPTION: json complies with the StudentBehavior object and has the required values.
		//
		// NOTE: The json could be an array of StudentBehavior records.
		// 
		StudentBehavior behavior; 
		try {
			behavior = getMapper().readValue(strJson, StudentBehavior.class);
			logger.debug(" >> inserting StudentBehavior record. ");
			classroomService.addStudentBehavior(behavior);
		} catch (JsonParseException e) {
			logger.error("Exception : % ", e);
		} catch (JsonMappingException e) {
			logger.error("Exception : % ", e);
		} catch (IOException e) {
			logger.error("IOException  :  % ", e);
		} catch (Exception e) {
			logger.error("Exception  :  % ", e);
		}
		logger.debug(" Returning - Behaviors synched."); 
		return Response.status(Response.Status.OK).build();
	}
	
	@POST
	@ApiOperation("comments")
	@Timed
	@Path("/comments")
	public Response syncComments(String strJson) {

		logger.debug(" RemoteSyncResource::syncComments()  :  strJson  =  " + strJson);

		//
		// TODO: Insert a new record in to the StudentBehavior table. 
		// 
		// ASSUMPTION: json complies with the StudentBehavior object and has the required values.
		//
		// NOTE: The json could be an array of StudentBehavior records.
		// 
		
		StudentBehavior behavior; 
		try {
			behavior = getMapper().readValue(strJson, StudentBehavior.class);
			logger.debug(" >> inserting StudentBehavior record. ");
			classroomService.addStudentBehavior(behavior);
		} catch (JsonParseException e) {
			logger.error("Exception : % ", e);
		} catch (JsonMappingException e) {
			logger.error("Exception : % ", e);
		} catch (IOException e) {
			logger.error("IOException  :  % ", e);
		} catch (Exception e) {
			logger.error("Exception  :  % ", e);
		}
		logger.debug(" Returning - Behaviors synched."); 
		return Response.status(Response.Status.OK).build();
	}

	@POST
	@ApiOperation("all")
	@Timed
	@Path("/all")
	public Response syncAll(String strJson) {

		logger.debug(" RemoteSyncResource::syncAll()  :  strJson  =  " + strJson);

		//
		// TODO: in the future we would like to be able to cache all the interactive data to be 
		//  saved on the device until a netwrok connection is available then push it all to a 
		//  single end-point to be stored server side. 
		//
		
		return Response.status(Response.Status.OK).build();
	}

}
