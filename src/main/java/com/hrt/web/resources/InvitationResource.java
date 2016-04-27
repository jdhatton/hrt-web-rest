package com.hrt.web.resources;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
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
import com.hrt.data.db.beans.Invitation;
import com.hrt.web.services.InvitationService;

 
	@Path("/invitation")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public class InvitationResource extends JsonResource {

		final static Logger logger = LoggerFactory.getLogger(InvitationResource.class);
		private final AtomicLong counter;
		private final InvitationService service;
		
		@Inject
		public InvitationResource(InvitationService service) {
			this.counter = new AtomicLong();
			this.service = service;
		}
		
		@POST
		@Timed
		@Path("/inviteStudent")
		public Response inviteStudent( String json) {
			
			logger.debug(" ["+counter.incrementAndGet()+ "] InvitationResource::add()  :  JSON  =  " + json);
			
			//
			// JSON should include: TeacherRemoteId, student email address, studentId ( should we gen a student remote ID ?? )
			//
			//  Consideration: how do we get the student email? proivide on the student tab in teacher app?
			//
			
			Invitation invitation = null;
			 
			try {
				invitation = getMapper().readValue(json, Invitation.class);
				if(invitation != null){
					
					// TODO:  Wrap these steps in an executerTask. 
					
					//  1). If we do not have the remotestudentId working yet then do a lookup for it.
					//  2). Generate unique activation code. 
					//  3). Generate email to provided email for student. 
					//  4). Save the activation code and all other data to INVITE_ACTIVATION table.
					//  5). send email. 
					
				}
			} catch (JsonParseException e) {
				logger.error(">> JsonParseException :  " + e.getMessage());
				e.printStackTrace();
			} catch (JsonMappingException e) {
				logger.error(">> JsonMappingException :  " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(">> IOException :  " + e.getMessage());
				e.printStackTrace();
			} catch(Exception e){
				logger.error(">> Exception :  " + e.getMessage());
				e.printStackTrace();
			}
			
			return Response.status(Response.Status.OK).build();
		}
		
		@POST
		@Timed
		@Path("/inviteParent")
		public Response inviteParent( String json) {
			
			logger.debug(" ["+counter.incrementAndGet()+ "] FeedbackResource::add()  :  JSON  =  " + json);

			//
			// JSON should include: TeacherRemoteId, parent email address, studentId ( should we gen a student remote ID ?? )
			//
			
			Invitation invitation = null;
			 
			try {
				invitation = getMapper().readValue(json, Invitation.class);
				if(invitation != null){
					
					// TODO:  Wrap these steps in an executerTask. 
					
					//  1). If we do not have the remotestudentId working yet then do a lookup for it.
					//  2). Generate unique activation code. 
					//  3). Generate email to provided email for parent. 
					//  4). Save the activation code and all other data to INVITE_ACTIVATION table.
					//  5). send email. 
					
				}
			} catch (JsonParseException e) {
				logger.error(">> JsonParseException :  " + e.getMessage());
				e.printStackTrace();
			} catch (JsonMappingException e) {
				logger.error(">> JsonMappingException :  " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(">> IOException :  " + e.getMessage());
				e.printStackTrace();
			} catch(Exception e){
				logger.error(">> Exception :  " + e.getMessage());
				e.printStackTrace();
			}
			
			return Response.status(Response.Status.OK).build();
		}
	}
