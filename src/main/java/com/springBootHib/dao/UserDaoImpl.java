package com.springBootHib.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springBootHib.model.Person;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{

	@Override
	@Transactional(readOnly = false)
	public int saveUser(Person user) {
		persist(user);
		return user.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAllUsers() {
		return (List<Person>)getSession().createCriteria(Person.class).list();
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUserById(int id) {
		Person user = (Person)getSession().load(Person.class, id);
		getSession().delete(user);
	}

	@Override
	public Person findUserById(int id) {
		Criteria criteria = getSession().createCriteria(Person.class);
		criteria.add(Restrictions.eq("id",id));
		return (Person) criteria.uniqueResult();
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUser(Person user) {
		getSession().update(user);
	}
	
}
