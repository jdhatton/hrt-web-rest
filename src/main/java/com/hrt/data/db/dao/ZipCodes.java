package com.hrt.data.db.dao;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.hrt.data.db.beans.ZipCode;
import com.hrt.data.db.mappers.ZipCodeMapper;

@RegisterMapper(ZipCodeMapper.class)
public interface ZipCodes {

 
    @SqlUpdate("insert into ZipCode (zipCode, zipCodeType, city, state,lat, lon, location, decommisioned, estimatedPopulation) "
    		+ " values (:zipCode, :zipCodeType, :city, :state, :lat, :lon, :location, :decommisioned, :estimatedPopulation)")
    int insert(@BindBean ZipCode something);
    

}
