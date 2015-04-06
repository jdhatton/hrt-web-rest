package com.hrt.web;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.hrt.web.dp.HelloWorldConfiguration;
import com.hrt.web.resources.HelloWorldResource;
import com.hrt.web.resources.ZipDistrictSchoolResource;


public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	 public static void main(String[] args) throws Exception {
	        new HelloWorldApplication().run(args);
	    }

	    @Override
	    public String getName() {
	        return "hello-world";
	    }

	    @Override
	    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
	    }

	    @Override
	    public void run(HelloWorldConfiguration configuration, Environment environment) {	       
	    	final HelloWorldResource helloWorld = new HelloWorldResource();	
//	    	final ZipDistrictSchoolResource zipDistricts = new ZipDistrictSchoolResource();
	    	environment.jersey().register(helloWorld);  
//	    	environment.jersey().register(zipDistricts);
	    }

}
