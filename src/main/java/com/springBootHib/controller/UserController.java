package com.springBootHib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springBootHib.model.Person;
import com.springBootHib.service.UserService;

@RestController
@RequestMapping(value="users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="{id}")
	public ResponseEntity<Person> getUser(@PathVariable("id") int id) {
		return new ResponseEntity<Person>(userService.findUserById(id), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Person>> getUsers() {
		return new ResponseEntity<List<Person>>(userService.findAllUsers(), HttpStatus.OK) ;
	}
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody Person user, UriComponentsBuilder builder) {
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<Person> updateUser(@RequestBody Person user) {
		userService.updateUser(user);
		return new ResponseEntity<Person>(user, HttpStatus.OK);
	}
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		userService.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
