package com.gcu.data;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.*;
import com.gcu.model.*;

public class RegisterDAO implements DataAccessInterface<UserRegistrationModel> {

	@Override
	public List<UserRegistrationModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(UserRegistrationModel user) {
		//
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
