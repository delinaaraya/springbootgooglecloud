package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationModel {
	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="User name must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	
	@NotNull(message="First Name is a required field")
	@Size(min=1, max=32, message="First Name must be between 1 and 32 characters")
	private String fname;
	
	@NotNull(message="Last Name is a required field")
	@Size(min=1, max=32, message="Last Name must be between 1 and 32 characters")
	private String lname;
	
	@NotNull(message="Email is a required field")
	@Size(min=1, max=32, message="Email must be between 1 and 32 characters")
	private String email;
	
	@NotNull(message="Phone Number is a required field")
	@Min(value=10, message="Phone Number must be 10 characters")
	private int phone;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}