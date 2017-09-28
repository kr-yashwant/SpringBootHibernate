package com.springBootHib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	protected void persist(Object entity) {
		getSession().persist(entity);
	}
	protected void delete(Object entity) {
		getSession().delete(entity);
	}
}
