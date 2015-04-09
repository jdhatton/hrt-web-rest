package com.hrt.web;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hrt.data.db.dao.DistrictDao;
import com.hrt.data.db.dao.DistrictDaoImpl;
import com.hrt.web.dp.HelloWorldConfiguration;
import com.hrt.web.resources.DataSyncResource;
import com.hrt.web.resources.HelloWorldResource;
import com.hrt.web.resources.ZipDistrictSchoolResource;
import com.hrt.web.services.DistrictService;
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
	    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {	       
	    	
	   	    	
//	    	final HelloWorldResource resource = new HelloWorldResource( );
//	    	environment.jersey().register(resource);
//	    	environment.jersey().register(zipDistricts);	    	
	    	
	    	
	    	Injector injector = createInjector(configuration);
	    	
	    	environment.jersey().register(injector.getInstance(HelloWorldResource.class));
	    	environment.jersey().register(injector.getInstance(ZipDistrictSchoolResource.class));
	    	environment.jersey().register(injector.getInstance(DataSyncResource.class));
  
	    }
	    
	    
		private Injector createInjector(final HelloWorldConfiguration conf) {
	        return Guice.createInjector(new AbstractModule() {
	            @Override
	            protected void configure() {
 
	            	bind(HelloWorldConfiguration.class).toInstance(conf); // if someone would like to @Inject ExampleServiceConfiguration
	            	//bind(MessagesConfiguration.class).toInstance(conf.getMessages()); // for ExampleResource, which does @Inject MessagesConfiguration
	            	bind(DistrictService.class).to(DistrictServiceImpl.class);
	            	bind(DistrictDao.class).to(DistrictDaoImpl.class);
//	            	bind(UserDao.class).to(UserDaoImpl.class);
//	            	bind(UserService.class).to(UserServiceImpl.class);		
//	            	bind(NcesEdGovWrapper.class).to(NcesEdGovWrapperImpl.class);
 
	            }
	        });
	    }

}
