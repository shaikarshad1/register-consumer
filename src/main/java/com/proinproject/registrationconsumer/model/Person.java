package com.proinproject.registrationconsumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Person {
	
	@Id
	private String userName;
	private String firstName;
	private String lastName;
	private String role="user";
	private String email;
	private String password;
	public Person() {
		super();
	}
	public Person(String userName, String firstName, String lastName, String role, String email, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Firstname, Lastname, username, email, password, role
}
