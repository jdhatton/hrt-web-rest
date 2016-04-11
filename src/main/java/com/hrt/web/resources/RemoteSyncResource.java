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
			}

			// 1). Get the Classroom with TeacherId
			logger.debug(" >> creating classroom ");
			Classroom classroom = classroomService.getClassroom(new Long(teacherId).longValue());

			// 2). Create a ClassroomStudent record with the newly created
			ClassroomStudent classroomStudent = new ClassroomStudent(classroom.getId(), student.getId()); 
			if( classroomService.addClassroomStudent(classroomStudent) < 0 ) {
				//
				//TODO:  We had an error creating this record. Log the Error.
				//
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
		} catch (Exception e) {
			logger.debug(" >> Exception  :  " + e.getMessage());
			e.printStackTrace();
		}

		return Response.status(Response.Status.OK).build();
	}

	@POST
	@ApiOperation("comments")
	@Timed
	@Path("/comments")
	public Response syncComments(String strJson) {

		logger.debug(" RemoteSyncResource::syncComments()  :  strJson  =  " + strJson);

		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Timed
	@ApiOperation("behaviors")
	@Path("/behaviors")
	public Response syncBehaviors(String strJson) {

		logger.debug(" RemoteSyncResource::syncBehaviors()  :  strJson  =  " + strJson);

		//
		// TODO: we should get he TeacherId, StudentId, Behavior, and the
		// Behavior Status
		//

		// 1). Insert record into the ClassroomBehaviors table.

		return Response.status(Response.Status.OK).build();
	}

	@POST
	@ApiOperation("all")
	@Timed
	@Path("/all")
	public Response syncAll(String strJson) {

		logger.debug(" RemoteSyncResource::syncAll()  :  strJson  =  " + strJson);

		return Response.status(Response.Status.OK).build();
	}

}
