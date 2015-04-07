package com.hrt.web.resources;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.hrt.data.db.beans.District;
import com.hrt.web.services.DistrictService;

@Path("/schoolSearch")
@Produces(MediaType.APPLICATION_JSON)
public class ZipDistrictSchoolResource {

	final static Logger logger = LoggerFactory.getLogger(ZipDistrictSchoolResource.class);
	private final AtomicLong counter;

	DistrictService service;
	
	@Inject
	public ZipDistrictSchoolResource(DistrictService service) {		
		this.counter = new AtomicLong();
		this.service = service;
	}

	@GET
	@Timed
	public List<District> lookupDistrictInfo(@QueryParam("zip") String zipCode) {

		logger.debug("looking up districts for zipCode : @", zipCode);
		List<District> districts = Lists.newArrayList();

		districts = service.findByZip(zipCode);

		return districts;
	}
	    
 
}
