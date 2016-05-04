package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.hrt.data.db.beans.Device;
import com.hrt.data.db.mappers.DeviceMapper;

@RegisterMapper(DeviceMapper.class)
public interface Devices {
	
    @SqlUpdate("insert into Device (platform, device, deviceToken, awsEndPointArn, userId, enabled, valid, lastUpdated) values (:platform, :device, :deviceToken, :awsEndPointArn, :userId, :enabled, :valid, :lastUpdated)")
    int insert(@BindBean Device device);
    
    @SqlQuery("select * from Device where id = :id")
    Device findById(@Bind("id") long id);
    
    @SqlQuery("select * from Device ")
    List<Device> findAll();
    
    @SqlQuery("select * from Device where userId = :userId")
    List<Device> findByUserId(@Bind("userId")long userId); 

}
