package com.cognizant.ers.authentication;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Authentication {
	
	public static String tableName;
	
	@Id
	private String username;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private int age;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Authentication(String username, String email, String password, String firstname, String lastname, int age) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	
	public Authentication() {
		// TODO Auto-generated constructor stub
	}
	
	
	private boolean validateUserInfo() {
		boolean valid = true;
		valid = username.matches("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$");
		/*	^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$
			 └─────┬────┘└───┬──┘└─────┬─────┘└─────┬─────┘ └───┬───┘
			       │         │         │            │           no _ or . at the end
			       │         │         │            │
			       │         │         │            allowed characters
			       │         │         │
			       │         │         no __ or _. or ._ or .. inside
			       │         │
			       │         no _ or . at the beginning
			       │
		       username is 8-20 characters long		*/
		valid = email.matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}");
		valid = password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");	// Minimum eight characters, at least one letter and one number
		return valid;
	}
	
	public void registerUser() {
		// TODO: Check whether the user exists in the database
		if(validateUserInfo()) {
			// TODO: Create a user record
		}
	}
	
	public void loginUser() {
		// TODO: Check whether the user exists in the database
		
		if(validateUserInfo()) {
			// TODO: Check whether the user details matches with the database records
		}
	}
	
	public void updateUserInfo() {
		if(validateUserInfo()) {
			// TODO: Update the user info
		}
	}

}
