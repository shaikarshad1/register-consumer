package com.proinproject.registrationconsumer.model;

public class usercredentials {

	private String userName;
	private String password;
	
	public usercredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public usercredentials() {
	}
	
	

}
