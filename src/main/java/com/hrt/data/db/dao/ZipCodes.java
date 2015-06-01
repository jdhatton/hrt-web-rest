package com.hrt.data.db.dao;

import java.util.Set;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.hrt.data.db.beans.ZipCode;
import com.hrt.data.db.mappers.ZipCodeMapper;

@RegisterMapper(ZipCodeMapper.class)
public interface ZipCodes {

 
    @SqlUpdate("insert into ZipCode (zipCode, zipCodeType, city, state,lat, lon, location, decommisioned, estimatedPopulation) "
    		+ " values (:zipCode, :zipCodeType, :city, :state, :lat, :lon, :location, :decommisioned, :estimatedPopulation)")
    int insert(@BindBean ZipCode something);
    
//    @SqlQuery("select z.zipCode from ZipCode z where zipCode ")
    
    @SqlQuery(" select z.zipCode from ZipCode as z  left join Districts as d on (z.zipCode=d.zip) where d.zip is null and length(z.zipCode) > 4 ")  
    Set<String> getAll( ); 
}
