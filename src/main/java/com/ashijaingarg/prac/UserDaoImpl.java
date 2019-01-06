package com.ashijaingarg.prac;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {

		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}

		public void addUser(User user) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(user);
			System.out.println("user saved successfully, Person Details="+user);
		}
}
