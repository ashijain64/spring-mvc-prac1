package com.ashijaingarg.prac.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.ashijaingarg.prac.dao.AppUserDAOImpl;
import com.ashijaingarg.prac.model.AppUser;

@Service
public class AppUserService {
	
	private AppUserDAOImpl appUserDaoImpl;

	public AppUserDAOImpl getAppUserDaoImpl() {
		return appUserDaoImpl;
	}

	public void setAppUserDaoImpl(AppUserDAOImpl appUserDaoImpl) {
		this.appUserDaoImpl = appUserDaoImpl;
	}

	@Transactional
	public void addAppUser(AppUser appUser) {
		System.out.println("----------------------appUser  : " + appUser);
		this.appUserDaoImpl.addAppUser(appUser);
	}
	
	@Transactional
	public void getAppUserId(int id) {
		this.appUserDaoImpl.getAppUserById(id);
	}
	

}
