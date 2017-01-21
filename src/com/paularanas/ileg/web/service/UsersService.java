package com.paularanas.ileg.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paularanas.ileg.web.dao.UsersOnline;
import com.paularanas.ileg.web.dao.UserDao;

@Service("usersService")
public class UsersService {
	private UserDao userDao;
	public List<UsersOnline> getCurrentUser(){
		return userDao.getUser();
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void createUser(UsersOnline user) {
		userDao.create(user);
		
	}

}
