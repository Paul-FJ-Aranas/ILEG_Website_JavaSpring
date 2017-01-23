package com.paularanas.ileg.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paularanas.ileg.web.dao.UsersOnline;
import com.paularanas.ileg.web.dao.UsersOnlineDao;

@Service("usersOnlineService")
public class UsersOnlineService {
	private UsersOnlineDao userDao;
	public List<UsersOnline> getCurrentUser(){
		return userDao.getUser();
	}
	@Autowired
	public void setUserDao(UsersOnlineDao userDao) {
		this.userDao = userDao;
	}
	public void createUser(UsersOnline user) {
		userDao.create(user);
		
	}

}
