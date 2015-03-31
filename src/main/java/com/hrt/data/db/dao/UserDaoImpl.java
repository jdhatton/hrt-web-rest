package com.hrt.data.db.dao;

import java.util.List;

import com.hrt.data.db.beans.User;

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
	
	public void addUser(User user) {

//		Users one = dbi.onDemand(Users.class);
//		one.insert(new User(8, "Mike"));
//		one.begin();
//		one.update(new User(8, "Michael"));
//		assertEquals("Mike", two.findById(8).getName());
//		one.commit();
//		assertEquals("Michael", two.findById(8).getName());
	}

	public void updateUser(User user) {

	}

}
