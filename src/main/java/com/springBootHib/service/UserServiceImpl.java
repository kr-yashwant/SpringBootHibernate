package com.springBootHib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBootHib.dao.UserDao;
import com.springBootHib.model.Person;

@Service("userService")
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	
	public int saveUser(Person user) {
		return dao.saveUser(user);
	}
	public List<Person> findAllUsers() {
		return dao.findAllUsers();
	}
	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}
	public Person findUserById(int id) {
		return dao.findUserById(id);
	}
	public void updateUser(Person user) {
		dao.updateUser(user);
	}
}
