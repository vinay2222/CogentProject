package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionfactory = sessionFactory;
	 }
	private Session getCurrentSession(){
		return sessionfactory.getCurrentSession();
	}
	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listusers() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from user").list();
	}

}
