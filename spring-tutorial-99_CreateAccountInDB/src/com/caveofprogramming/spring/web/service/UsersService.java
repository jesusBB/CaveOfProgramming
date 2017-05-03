package com.caveofprogramming.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caveofprogramming.spring.web.dao.User;
import com.caveofprogramming.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	
	private UsersDao usersDao;
	
	@Autowired	
	public void setOffersDAO(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	
	
	public void create(User user){
		usersDao.create(user);
	}

	
}
