package com.ashijaingarg.prac;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private UserDaoImpl userDaoImpl;
	
	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Transactional
	public void addUser(User user) {
		this.userDaoImpl.addUser(user);
	}
}
