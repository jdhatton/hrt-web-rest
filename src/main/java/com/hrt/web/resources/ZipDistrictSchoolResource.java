package com.hrt.web.resources;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.hrt.data.db.beans.District;

@Path("/schoolSearch")
@Produces(MediaType.APPLICATION_JSON)
public class ZipDistrictSchoolResource {


	private final AtomicLong counter;

	    public ZipDistrictSchoolResource() {
	        this.counter = new AtomicLong();
	    }

	    @GET
	    @Timed
	    public List<District> lookupDistrictInfo(@QueryParam("zip") String zipCode) {
	         	        
	    	List<District> districts = Lists.newArrayList();
	    	return districts;
	    }
	    
 
}
