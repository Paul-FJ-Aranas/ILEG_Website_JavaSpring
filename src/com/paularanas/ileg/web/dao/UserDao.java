package com.paularanas.ileg.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDao {

	private JdbcTemplate jdbcData;

	public List<User> getUsers() {
		return jdbcData.query("select * from users", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				User user = new User();
				user.setId(arg0.getInt("id"));
				user.setName(arg0.getString("name"));
				user.setEmail(arg0.getString("email"));
				return user;
			}}
				);
		 
		
	}

	@Autowired
	public void setDataSource(DataSource jdbcData) {
		this.jdbcData = new JdbcTemplate(jdbcData);
	}

}
