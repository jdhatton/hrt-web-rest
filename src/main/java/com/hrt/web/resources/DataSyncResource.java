package com.hrt.web.resources;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.hrt.web.core.Saying;
import com.hrt.web.resources.client.DataSyncResponse;


@Path("/registerUser")
@Produces(MediaType.APPLICATION_JSON)
public class DataSyncResource {

	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	    public DataSyncResource(String template, String defaultName) {
	        this.template = template;
	        this.defaultName = defaultName;
	        this.counter = new AtomicLong();
	    }

	    @GET
	    @Timed
	    public Saying sayHello(@QueryParam("name") Optional<String> name) {
	        final String value = String.format(template, name.or(defaultName));
	        return new Saying(counter.incrementAndGet(), value);
	    }
	    
	    @POST
	    @Timed
	    public DataSyncResponse syncData(@QueryParam("data") String data) {

	    	System.out.println(" DataSyncResource::syncData() = " + data);
	    	
	        return new DataSyncResponse("SUCCESS");
	    }
	    
	    @POST
	    @Timed
	    @Path("update/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public int updateRecord(@PathParam("id") int id, List<Entity> entities) {
	      // Do something with entities...
	      return 0;
	    }
}
