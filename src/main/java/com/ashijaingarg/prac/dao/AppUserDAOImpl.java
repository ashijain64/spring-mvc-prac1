package com.ashijaingarg.prac.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ashijaingarg.prac.model.AppUser;

@Repository
public class AppUserDAOImpl {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addAppUser(AppUser appUser) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(appUser);
		System.out.println("appUser saved successfully, appUser Details="+appUser );
	}
	
	public AppUser getAppUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		return (AppUser) session.get(AppUser.class, id);
	}

}
