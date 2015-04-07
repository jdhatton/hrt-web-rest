package com.hrt.web;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hrt.web.dp.HelloWorldConfiguration;
import com.hrt.web.resources.HelloWorldResource;
import com.hrt.web.resources.ZipDistrictSchoolResource;
import com.hrt.web.services.DistrictServiceImpl;


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
	    	
	    	Injector injector = Guice.createInjector();
	    	
	    	environment.jersey().register(injector.getInstance(HelloWorldResource.class));
	    	environment.jersey().register(injector.getInstance(ZipDistrictSchoolResource.class));
	    	
	    	 
	    	
//	    	final HelloWorldResource helloWorld = new HelloWorldResource();	
//	    	final ZipDistrictSchoolResource zipDistricts = new ZipDistrictSchoolResource(new DistrictServiceImpl(new DistrictDaoImpl()));
//	    	
//	    	environment.jersey().register(helloWorld);  
//	    	environment.jersey().register(zipDistricts);


	    }
	    
	    @SuppressWarnings("unused")
		private Injector createInjector(final HelloWorldConfiguration conf) {
	        return Guice.createInjector(new AbstractModule() {
	            @Override
	            protected void configure() {
	                bind(HelloWorldConfiguration.class).toInstance(conf); // if someone would like to @Inject ExampleServiceConfiguration
	                //bind(MessagesConfiguration.class).toInstance(conf.getMessages()); // for ExampleResource, which does @Inject MessagesConfiguration
	            }
	        });
	    }

}
