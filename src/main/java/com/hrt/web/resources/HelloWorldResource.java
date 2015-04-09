/**
 * 
 */
package com.hrt.web.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import runners.ZipCodeLoaderRunner;

import com.codahale.metrics.annotation.Timed;
import com.hrt.web.core.Saying;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
 
	final static Logger logger = LoggerFactory.getLogger(HelloWorldResource.class);
    private final AtomicLong counter;
    
 
    public HelloWorldResource() { 
        this.counter = new AtomicLong();         
    }

    @GET
    @Timed
    public Saying sayHello(@DefaultValue("null")  @QueryParam("name") String name) {
    	
    	logger.debug(" >>  sayHello() logged....");
        final String value = name;
        
        
        //
        // For now we can trigger this here
        //
		ZipCodeLoaderRunner obj = new ZipCodeLoaderRunner();
		obj.run();
        
        
        return new Saying(counter.incrementAndGet(), value);
    }
}
