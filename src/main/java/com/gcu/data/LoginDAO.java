package com.gcu.data;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.*;
import com.gcu.model.*;

public class LoginDAO implements DataAccessInterface<UserLoginModel> {

	@Override
	public List<UserLoginModel> findAll() {
		//
		return null;
	}

	@Override
	public void create(UserLoginModel user) {
		//
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
