package com.hrt.data.db.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import com.hrt.data.db.beans.User;
import com.hrt.data.db.mappers.UserMapper;

@RegisterMapper(UserMapper.class)
public interface Users extends Transactional<Users> {
 
	//
	// TODO: add a deviceToken field to the DB
	//
    @SqlUpdate("insert into User (schoolDistrict, schoolGrade, schoolName, firstName, lastName, status, registered, role, zipCode, email, gender, paid, password, phone ) "
    		+  "values (:schoolDistrict, :schoolGrade , :schoolName ,:firstName ,:lastName ,:status ,:registered ,:role ,:zipCode ,:email ,:gender , :paid, :password, :deviceId    )")
    @GetGeneratedKeys
    long insert(@BindBean User user);
    
    @SqlQuery("select id, email from User where id = :id")
    User findById(@Bind("id") long id);
    
    @SqlQuery("select * from User ")
    List<User> findAll();
    
}
