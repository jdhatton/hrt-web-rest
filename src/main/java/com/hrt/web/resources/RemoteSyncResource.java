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
import com.hrt.web.resources.client.AddStudentDto;
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
			logger.debug(" >> mapping new student to database ");
			//
			// TODO: does this map into a student? or should we have a hybrid
			// object for this before parsing.
			//
			AddStudentDto dto = getMapper().readValue(strJson, AddStudentDto.class);
			logger.debug("Parsed student DTO: %", dto.toString());
			

			if (dto != null) {
				student = new Student(dto);
				//
				// TODO: load the student object from the dto object. 
				//
				
				
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
					ClassroomStudent classRmStudent = new ClassroomStudent();
					classRmStudent.setClassroomId(classroom.getId());
					classRmStudent.setStudentId(student.getId());
					long classRmStudentId = classroomService.addClassroomStudent(classroomStudent);
					if(classRmStudentId <= 0){
						logger.error("\n\n ERROR adding student: creating ClassroomStudent record %", strJson);
					}
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
	@ApiOperation("behavior")
	@Path("/behavior")
	public Response syncBehavior(String strJson) {

		logger.debug(" RemoteSyncResource::syncBehaviors()  :  strJson  =  " + strJson);

		/**
			strJson  =  {
			  "statusComment" : "TEsting 1.2.2",
			  "createdDate" : "2016-04-18T15:28:04",
			  "statusId" : 1,
			  "studentId" : 2,
			  "teacherId" : "152"
			}
		 */
		
		
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
	@Timed
	@ApiOperation("behaviors")
	@Path("/behaviors")
	public Response syncBehaviors(String strJson) {

		logger.debug(" RemoteSyncResource::syncBehaviors()  :  strJson  =  " + strJson);

		/**
 strJson  =  {
  "9studentIdNumber" : "121212",
  "2studentId" : 4,
  "8createdDate" : "2016-04-18T19:37:07",
  "1studentId" : 2,
  "7statusId" : 1,
  "2statusId" : 1,
  "1createdDate" : "2016-04-18T07:21:20",
  "10statusId" : 3,
  "6statusId" : 2,
  "4createdDate" : "2016-04-18T15:28:04",
  "1statusId" : 1,
  "9statusComment" : "ewe tweeter",
  "9studentId" : 4,
  "10studentIdNumber" : "13123123",
  "8studentId" : 2,
  "7createdDate" : "2016-04-18T15:56:53",
  "6statusComment" : "Yellow Test",
  "7statusComment" : "Green Test",
  "7studentId" : 2,
  "8statusComment" : "Test",
  "1studentIdNumber" : "11111111",
  "10createdDate" : "2016-04-18T19:38:29",
  "3statusComment" : "Testing",
  "2studentIdNumber" : "121212",
  "5statusComment" : "Red Test",
  "3createdDate" : "2016-04-18T15:16:57",
  "3studentIdNumber" : "121212",
  "4statusComment" : "TEsting 1.2.2",
  "5statusId" : 3,
  "4studentIdNumber" : "11111111",
  "1statusComment" : "Doing some stuff",
  "6createdDate" : "2016-04-18T15:56:44",
  "2statusComment" : "Test",
  "6studentId" : 2,
  "5studentId" : 4,
  "9statusId" : 2,
  "10statusComment" : "Tricky",
                                   "teacherId" : "152",
  "4studentId" : 2,
  "4statusId" : 1,
  "9createdDate" : "2016-04-18T19:37:34",
  "5studentIdNumber" : "121212",
  "3studentId" : 4,
  "2createdDate" : "2016-04-18T13:53:26",
  "6studentIdNumber" : "11111111",
  "7studentIdNumber" : "11111111",
  "5createdDate" : "2016-04-18T15:56:34",
  "8statusId" : 1,
  "8studentIdNumber" : "11111111",
  "3statusId" : 2,
  "10studentId" : 8
}
		 */
		
		
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
		
		/**
		  strJson  =  {
			  "teacherId" : "152",
			  "1studentId" : "8",
			  "1studentIdNumber" : "13123123",
			  "1createdDate" : "2016-04-18T19:38:10",
			  "1comment" : "We're we're"
			}
		 */
		
		
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
