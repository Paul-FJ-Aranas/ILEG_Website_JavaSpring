package com.paularanas.ileg.web.dao;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.paularanas.ileg.web.validation.constraints.UserEmailValidation;

public class UsersOnline implements Serializable {

	private static final long serialVersionUID = -7587069038063448569L;
	private int id;
	@Size(min=2, max = 75)
	private String name;
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*", message="This doesn't seem like a valid email address. Try again")
	@UserEmailValidation
	private String email;

	public UsersOnline() {
	
	}

	public UsersOnline(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public UsersOnline(int id, String name, String email) {
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
