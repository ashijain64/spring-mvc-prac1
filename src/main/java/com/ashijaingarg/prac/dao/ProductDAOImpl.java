package com.ashijaingarg.prac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ashijaingarg.prac.model.Product;
import com.ashijaingarg.prac.model.SubCategory;

@Repository
public class ProductDAOImpl {
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		System.out.println("Product saved successfully, Product Details="+product);
	}
	
	@SuppressWarnings("unchecked")   
	public List<Product> getAllProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Product").list();    //to note down 
	}
	 
	public SubCategory getSubCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (SubCategory) session.get(SubCategory.class, id);
	}

}
