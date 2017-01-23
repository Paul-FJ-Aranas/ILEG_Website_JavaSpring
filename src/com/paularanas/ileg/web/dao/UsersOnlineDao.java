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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usersOnlineDao")
public class UsersOnlineDao {

	private NamedParameterJdbcTemplate jdbcData;

	public List<UsersOnline> getUser() {

		return jdbcData.query("select * from usersonline", new RowMapper<UsersOnline>() {

			@Override
			public UsersOnline mapRow(ResultSet arg0, int arg1) throws SQLException {
				UsersOnline user = new UsersOnline();
				user.setId(arg0.getInt("id"));
				user.setName(arg0.getString("name"));
				user.setEmail(arg0.getString("email"));
				return user;
			}
		});
	}

	public boolean update(UsersOnline user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbcData.update("update users set name = :name, email = :email where id= :id", params) == 1;
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbcData.update("delete from usersonline where id = :id;", params) == 1;
	}

	public boolean create(UsersOnline user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbcData.update("insert into usersonline (name, email) values (:name, :email)", params) == 1;

	}
	@Transactional
	public int[] create(List<UsersOnline> users) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(users.toArray());
		return jdbcData.batchUpdate("insert into usersonline (name, email), values (:name, :email)", params);
	}

	@Autowired
	public void setDataSource(DataSource jdbcData) {
		this.jdbcData = new NamedParameterJdbcTemplate(jdbcData);
	}

}
