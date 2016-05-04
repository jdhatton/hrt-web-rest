package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.hrt.data.db.beans.ApplicationConfiguration;
import com.hrt.data.db.mappers.ApplicationConfigurationMapper;

@RegisterMapper(ApplicationConfigurationMapper.class)
public interface ApplicationConfigurations {

    @SqlQuery("select * from ApplicationConfiguration ")
    List<ApplicationConfiguration> findAll();
    
    @SqlQuery("select * from ApplicationConfiguration where id = :id")
    ApplicationConfiguration findById(@Bind("id") long id);
    
    @SqlQuery("select * from ApplicationConfiguration where name = :name")
    ApplicationConfiguration findByName(@Bind("name")String name); 
    
    @SqlQuery("select * from ApplicationConfiguration where platform = :platform")
    List<ApplicationConfiguration> findByPlatform(@Bind("platform")String platform); 
}
