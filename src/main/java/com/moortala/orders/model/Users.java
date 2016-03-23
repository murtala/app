package com.moortala.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String user;
	public String password;
	public long user_type;
	
	//get the id
	public long getId() {
		return id;
	}
	//sets the id
	public void setId(long id) {
		this.id = id;
	}
	//get the user name
	public String getUser() {
		return user;
	}
	//sets the username
	public void setUser(String user) {
		this.user = user;
	}
	//get the password
	public String getPassword() {
		return password;
	}
	//sets the password
	public void setPassword(String password) {
		this.password = password;
	}
	//get the user type
	public long getUserType() {
		return user_type;
	}
	//sets the usertype
	public void setUserType(long userType) {
		this.user_type = userType;
	}	
	
}
