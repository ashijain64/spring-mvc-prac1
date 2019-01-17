package com.ashijaingarg.prac.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ashijaingarg.prac.model.Cart;

@Repository
public class CartDAOImpl {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCart(Cart cart) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cart);
		System.out.println("cart saved successfully, appUser Details="+cart );
	}

	public Cart getCartById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		return (Cart) session.get(Cart.class, id);
	
	}
	
	public Optional<Cart> getCartByUserId(int user_id) {
		Session session = this.sessionFactory.getCurrentSession();		
		String hql = "FROM Cart as c where c.user.id = "+ user_id + "";
		Query query = session.createQuery(hql);
		//query.setParameter("id",user_id);
		List carts = query.list();
		return carts.size() > 0? Optional.of((Cart)carts.get(0)) : Optional.empty();
	}

}
