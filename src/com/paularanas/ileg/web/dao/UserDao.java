package com.paularanas.ileg.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDao {

	private JdbcTemplate jdbcData;

	public List<User> getUsers() {
		return null;
	}

	@Autowired
	public void setDataSource(DataSource jdbcData) {
		this.jdbcData = new JdbcTemplate(jdbcData);
	}

}
