package com.hrt.web.services;

import java.util.List;

import com.hrt.data.db.beans.User;

public interface UserService {

	public List<User> getAllUsers() ;
	
	public User getUser( long Id);
	
	public long addUser(User user);
	
}
