package com.hrt.data.db.dao;

import java.util.List;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.hrt.data.db.beans.District;
import com.hrt.data.db.mappers.DistrictMapper;

@RegisterMapper(DistrictMapper.class)
public interface Districts {

	
	
    @SqlUpdate("insert into Districts (id, name, address,phone, numberOfStudents,numberOfSchools, fullDetailURL, distance, lastModified, zip) values (:id, :name, :address, :phone, :numStudents, :numSchools, :htmlLink, :distance, :lastModified, :zip)")
    int insert(@BindBean District something);
    
    @SqlQuery("select * from Districts where id = :id")
    District findById(@Bind("id") long id);
    
    @SqlQuery("select * from Districts ")
    List<District> findAll();
    
    @SqlQuery("select * from Districts where zip = :zip")
    List<District> findByZip(@Bind("zip")String zip); 
}
