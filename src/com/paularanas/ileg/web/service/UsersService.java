package com.paularanas.ileg.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paularanas.ileg.web.dao.User;
import com.paularanas.ileg.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	private UsersDao usersDao;

	@Autowired
	public void setUserDao(UsersDao userDao) {
		this.usersDao = userDao;
	}
	public void createUser(User user) {
		usersDao.create(user);
		
	}
	public boolean exists(String username) {
		return usersDao.exists(username);
	}

}
