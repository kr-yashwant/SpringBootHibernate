package com.springBootHib.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Table
@XmlRootElement
@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 5451976843299322285L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@OneToMany(mappedBy="person")
	private Set<Vehicle> vehicles;
		
	public Person() {
		
	}
	public Person(String firstName, String lastName, Integer id, Set<Vehicle> vehicles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicles = vehicles;
	}
	
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
