package com.paularanas.ileg.web.dao;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -7587069038063448569L;
	private int id;
	private String name;
	private String email;

	public User() {
	
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
