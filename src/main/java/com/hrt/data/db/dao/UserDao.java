package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.User;

public interface UserDao {

	public List<User> findAll() ;
	
	public User findById(long Id);
	
	public long addUser(User user) ;

	public void updateUser(User user);
}
