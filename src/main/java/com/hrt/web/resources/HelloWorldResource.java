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

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.hrt.web.core.Saying;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
 
    private final AtomicLong counter;

    public HelloWorldResource() {
 
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@DefaultValue("null")  @QueryParam("name") String name) {
        final String value = name;
        return new Saying(counter.incrementAndGet(), value);
    }
}
