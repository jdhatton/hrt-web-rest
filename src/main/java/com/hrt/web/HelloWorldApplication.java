package com.hrt.web;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hrt.data.db.dao.ClassroomBehaviorDao;
import com.hrt.data.db.dao.ClassroomDao;
import com.hrt.data.db.dao.ClassroomStudentsDao;
import com.hrt.data.db.dao.DistrictDao;
import com.hrt.data.db.dao.FeedbackDao;
import com.hrt.data.db.dao.StudentBehaviorDao;
import com.hrt.data.db.dao.StudentDao;
import com.hrt.data.db.dao.UserDao;
import com.hrt.data.db.dao.ZipCodeDao;
import com.hrt.data.db.dao.impl.ClassroomBehaviorDaoImpl;
import com.hrt.data.db.dao.impl.ClassroomDaoImpl;
import com.hrt.data.db.dao.impl.ClassroomStudentsDaoImpl;
import com.hrt.data.db.dao.impl.DistrictDaoImpl;
import com.hrt.data.db.dao.impl.FeedbackDaoImpl;
import com.hrt.data.db.dao.impl.StudentBehaviorDaoImpl;
import com.hrt.data.db.dao.impl.StudentDaoImpl;
import com.hrt.data.db.dao.impl.UserDaoImpl;
import com.hrt.data.db.dao.impl.ZipCodeDaoImpl;
import com.hrt.web.dp.HelloWorldConfiguration;
import com.hrt.web.resources.FeedbackResource;
import com.hrt.web.resources.HelloWorldResource;
import com.hrt.web.resources.RemoteSyncResource;
import com.hrt.web.resources.UserResource;
import com.hrt.web.resources.ZipDistrictSchoolResource;
import com.hrt.web.services.ClassroomService;
import com.hrt.web.services.DistrictService;
import com.hrt.web.services.FeedbackService;
import com.hrt.web.services.StudentService;
import com.hrt.web.services.UserService;
import com.hrt.web.services.ZipCodeService;
import com.hrt.web.services.impl.ClassroomServiceImpl;
import com.hrt.web.services.impl.DistrictServiceImpl;
import com.hrt.web.services.impl.FeedbackServiceImpl;
import com.hrt.web.services.impl.StudentServiceImpl;
import com.hrt.web.services.impl.UserServiceImpl;
import com.hrt.web.services.impl.ZipCodeServiceImpl;


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

	    	bootstrap.addBundle(new SwaggerBundle<HelloWorldConfiguration>() {
	            @Override
	            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(HelloWorldConfiguration configuration) {
	                return configuration.swaggerBundleConfiguration;
	            }
	        });
	    }
	    
	    @Override
	    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {	       
	    	
	   	    	
//	    	final HelloWorldResource resource = new HelloWorldResource( );
//	    	environment.jersey().register(resource);
//	    	environment.jersey().register(zipDistricts);	    	
	    	
	    	Injector injector = createInjector(configuration);
	    	
	    	environment.jersey().register(injector.getInstance(HelloWorldResource.class));
	    	environment.jersey().register(injector.getInstance(ZipDistrictSchoolResource.class));
	    	environment.jersey().register(injector.getInstance(UserResource.class));
	    	environment.jersey().register(injector.getInstance(FeedbackResource.class));
	    	environment.jersey().register(injector.getInstance(RemoteSyncResource.class));
	    }
	    
	    
		private Injector createInjector(final HelloWorldConfiguration conf) {
	        return Guice.createInjector(new AbstractModule() {
	            @Override
	            protected void configure() {
 
	            	bind(HelloWorldConfiguration.class).toInstance(conf); // if someone would like to @Inject ExampleServiceConfiguration
	            	bind(DistrictService.class).to(DistrictServiceImpl.class);
	            	bind(DistrictDao.class).to(DistrictDaoImpl.class);
	            	bind(ZipCodeService.class).to(ZipCodeServiceImpl.class);
	            	bind(ZipCodeDao.class).to(ZipCodeDaoImpl.class);
	            	bind(UserService.class).to(UserServiceImpl.class);
	            	bind(StudentService.class).to(StudentServiceImpl.class);
	            	bind(ClassroomService.class).to(ClassroomServiceImpl.class);
	            	
	            	bind(UserDao.class).to(UserDaoImpl.class);
	            	bind(FeedbackService.class).to(FeedbackServiceImpl.class);	
	            	bind(FeedbackDao.class).to(FeedbackDaoImpl.class);	
	            	bind(ClassroomDao.class).to(ClassroomDaoImpl.class);
	            	bind(ClassroomBehaviorDao.class).to(ClassroomBehaviorDaoImpl.class);
	            	bind(ClassroomStudentsDao.class).to(ClassroomStudentsDaoImpl.class);
	            	bind(StudentBehaviorDao.class).to(StudentBehaviorDaoImpl.class);
	            	bind(StudentDao.class).to(StudentDaoImpl.class);
	            	
//	            	bind(NcesEdGovWrapper.class).to(NcesEdGovWrapperImpl.class);
	            	//bind(MessagesConfiguration.class).toInstance(conf.getMessages()); // for ExampleResource, which does @Inject MessagesConfiguration
 
	            }
	        });
	    }

}
