package com.gcu.data;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.*;
import com.gcu.model.*;

@Service
public class RegisterDAO implements DataAccessInterface<UserRegistrationModel> {
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public RegisterDAO(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	//Finds all users in the database.
	@Override
	public List<UserRegistrationModel> findAll() {
		String sql = "SELECT * FROM USERREGISTRATION";
		List<UserRegistrationModel> registrationList = new ArrayList<UserRegistrationModel>();
		SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
		while(srs.next()) {
			registrationList.add(new UserRegistrationModel(srs.getString("Username"), srs.getString("UserPassword"), 
					srs.getString("UserFName"), srs.getString("UserLName"), srs.getString("UserEmail"), srs.getInt("UserPhone")));
			}
		return registrationList;
	}

	//Creates a user.
	@Override
	public void create(UserRegistrationModel user) {
		String sql = "INSERT INTO USERREGISTRATION (USERNAME, USERPASSWORD, USERFNAME, USERLNAME, USEREMAIL, USERPHONE) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getEmail(), user.getPhone());
	}

	//@Override
	public UserRegistrationModel findByID(int id) {
		//
		return null;
	}
	
	@Override
	public void update(UserRegistrationModel user) {
		//
	}

	@Override
	public void delete(UserRegistrationModel user) {
		//
	}
}
