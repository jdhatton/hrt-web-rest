package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.hrt.data.db.beans.District;
import com.hrt.data.db.mappers.DistrictMapper;

@RegisterMapper(DistrictMapper.class)
public interface Districts {

    @SqlUpdate("insert into Districts (id, name) values (:id, :name)")
    int insert(@BindBean District something);
    
    @SqlQuery("select id, email from District where id = :id")
    District findById(@Bind("id") long id);
    
    @SqlQuery("select * from District ")
    List<District> findAll();
}
