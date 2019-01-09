package com.ashijaingarg.prac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ashijaingarg.prac.model.Category;
import com.ashijaingarg.prac.model.SubCategory;

@Repository
public class SubCategoryDAOImpl {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void addSubCategory(SubCategory subCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(subCategory);
		System.out.println("SubCategory saved successfully, Category Details="+subCategory);
	}
	
	@SuppressWarnings("unchecked")   
	public List<SubCategory> getAllSubCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from SubCategory").list();    //to note down 
	}

	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category persistedCategory = (Category) session.get(Category.class, id);
		return persistedCategory;
	}

}
