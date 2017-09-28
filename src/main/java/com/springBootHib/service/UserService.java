package com.springBootHib.service;

import java.util.List;

import com.springBootHib.model.Person;

public interface UserService {
	int saveUser(Person user);
	List<Person> findAllUsers();
	void deleteUserById(int id);
	Person findUserById(int id);
	void updateUser(Person user);
}
