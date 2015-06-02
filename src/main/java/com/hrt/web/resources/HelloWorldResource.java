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

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.hrt.web.core.Saying;
import com.hrt.web.services.ZipCodeService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/hello-world")
@Api("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
 
	final static Logger logger = LoggerFactory.getLogger(HelloWorldResource.class);
    private final AtomicLong counter;
    
    ZipCodeService service;
	
	@Inject
    public HelloWorldResource(ZipCodeService service) { 
        this.counter = new AtomicLong();    
        this.service = service;
    }

    @GET
    @ApiOperation("sayHello")
    @Timed
    public Saying sayHello(@DefaultValue("null")  @QueryParam("name") String name) {
    	
    	logger.debug(" >>  sayHello() logged....");
        final String value = name;
        
        
        //
        // For now we can trigger this here
        //
//		ZipCodeLoaderRunner obj = new ZipCodeLoaderRunner();
//		List<ZipCode> zips = obj.run();
//		
//		
//		logger.debug("Processing ZipCodes ["+zips.size()+"]");
//		
//		for(ZipCode zip : zips){
//			service.addZipCode(zip);
//		}
//		logger.debug("\nProcessing ZipCodes COMPLETE ");
        
        return new Saying(counter.incrementAndGet(), value);
    }
}
