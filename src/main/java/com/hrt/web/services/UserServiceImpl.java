package com.hrt.web.services;

import java.util.List;

import javax.inject.Inject;

import com.hrt.data.db.beans.User;
import com.hrt.data.db.dao.UserDao;

public class UserServiceImpl implements UserService {
		
	UserDao userDao;

	@Inject
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;		
	}
	
	public List<User> getAllUsers() {			
		return userDao.findAll();		
	}
	
	public User getUser( long Id) {		
		return userDao.findById(Id);		
	}
	
}
