package com.hrt.web;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrt.web.dp.HelloWorldConfiguration;
import com.hrt.web.health.TemplateHealthCheck;
import com.hrt.web.resources.HelloWorldResource;


public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	static final Logger LOG = LoggerFactory.getLogger(HelloWorldApplication.class);
	
	 public static void main(String[] args) throws Exception {
	        new HelloWorldApplication().run(args);
	    }

	    @Override
	    public String getName() {
	        return "hello-world";
	    }

	    @Override
	    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
	        
	    	//
	    	// Add Swagger-UI
	    	//
 //	    	bootstrap.addBundle(new AssetBundle("/swagger/", "/docs", "index.html"));
 //	    	bootstrap.setName("swagger-sample");
	    }

	    @Override
	    public void run(HelloWorldConfiguration configuration,
	                    Environment environment) {
	    	
	    	LOG.trace("Hello World!");
	    	LOG.debug("How are you today?");
	    	LOG.info("I am fine.");
	    	LOG.warn("I love programming.");
	    	LOG.error("I am programming.");
	       
	    	
	    	final HelloWorldResource resource = new HelloWorldResource(
	    	        configuration.getTemplate(),
	    	        configuration.getDefaultName()
	    	    );
	    	final TemplateHealthCheck healthCheck =
	    	        new TemplateHealthCheck(configuration.getTemplate());
	    	    environment.healthChecks().register("template", healthCheck);
	    	    
	    	environment.jersey().register(resource);
	    	
	    }

}
