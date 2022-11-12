package com.gcu.data;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.*;
import com.gcu.model.*;

@Service
public class LoginDAO implements DataAccessInterface<UserLoginModel> {
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public LoginDAO(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	//Finds all users in the database.
	@Override
	public List<UserLoginModel> findAll() {
		String sql = "SELECT * FROM USERLOGIN";
		List<UserLoginModel> loginList = new ArrayList<UserLoginModel>();
		SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
		while(srs.next()) {
			loginList.add(new UserLoginModel(srs.getString("username"),srs.getString("userpassword")));
			}
		return loginList;
	}

	//Creates a user.
	@Override
	public void create(UserLoginModel user) {
		String sql = "INSERT INTO USERLOGIN (USERID, USERNAME, USERPASSWORD) VALUES (?, ?, ?)";
		jdbcTemplateObject.update(sql, 2, user.getUsername(), user.getPassword());
	}

	//@Override
	public UserLoginModel findByID(int id) {
		//
		return null;
	}

	@Override
	public void update(UserLoginModel user) {
		//
	}

	@Override
	public void delete(UserLoginModel user) {
		//
	}

}
