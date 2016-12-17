package com.paularanas.ileg.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDao {

	private NamedParameterJdbcTemplate jdbcData;

	public User getUser(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbcData.queryForObject("select * from users where id =:id", params, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				User user = new User();
				user.setId(arg0.getInt("id"));
				user.setName(arg0.getString("name"));
				user.setEmail(arg0.getString("email"));
				return user;
			}
		});
	}
	public boolean update(User user){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbcData.update("update users set name = :name, email = :email where id= :id", params) == 1;
	}
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbcData.update("delete from users where id = :id;", params) ==1;
	}
	
	public boolean create(User user){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbcData.update("insert into users (name, email), values (:name, :email)", params) == 1;
	
	}

	@Autowired
	public void setDataSource(DataSource jdbcData) {
		this.jdbcData = new NamedParameterJdbcTemplate(jdbcData);
	}

}
