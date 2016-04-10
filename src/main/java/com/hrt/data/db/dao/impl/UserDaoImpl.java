package com.hrt.data.db.dao.impl;

import java.util.List;

import com.hrt.data.db.beans.User;
import com.hrt.data.db.dao.DAO;
import com.hrt.data.db.dao.UserDao;
import com.hrt.data.db.dao.Users;

public class UserDaoImpl extends DAO implements UserDao{
	 
	public UserDaoImpl() { }

	public List<User> findAll() {
		Users all = DAO.getDBI().onDemand(Users.class);
		return all.findAll();		
	}
	
	public User findById(long Id) {
		Users dao = DAO.getDBI().onDemand(Users.class);
		return dao.findById(Id);
	}
	
	public long addUser(User user) {
		Users one = DAO.getDBI().onDemand(Users.class);
		return one.insert(user);
	}

	public void updateUser(User user) {

	}

}
