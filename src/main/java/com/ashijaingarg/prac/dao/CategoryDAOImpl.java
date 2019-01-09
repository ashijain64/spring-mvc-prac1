package com.ashijaingarg.prac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ashijaingarg.prac.model.Category;

@Repository
public class CategoryDAOImpl {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
		System.out.println("Category saved successfully, Category Details="+category);
	}
	
	@SuppressWarnings("unchecked")   
	public List<Category> getAllCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Category").list();    //to note down 
	}

}
