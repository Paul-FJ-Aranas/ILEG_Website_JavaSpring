package com.paularanas.ileg.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.paularanas.ileg.web.validation.constraints.UserEmailValidation;

public class User {
	@Size(min = 7, max = 18)
	@NotBlank
	@Pattern(regexp = "^\\w{8,}$")
	private String username;
	@Size(min = 7, max = 18)
	@NotBlank
	@Pattern(regexp = "^\\{8,}$")
	private String password;

	@UserEmailValidation
	private String email;
	private String authority;
	private boolean enabled = false;

	public User(String username, String password, String email, String authority, boolean enabled) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.authority = authority;
		this.enabled = enabled;
	}

	public User() {

	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
