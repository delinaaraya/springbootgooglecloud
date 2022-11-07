package com.gcu.data;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.*;
import com.gcu.model.*;

@Service
public class ProductDAO implements DataAccessInterface<ProductModel> {
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public ProductDAO(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	//Finds all products in the database.
	@Override
	public List<ProductModel> findAll() {
		String sql = "SELECT * FROM PRODUCT";
		List<ProductModel> productList = new ArrayList<ProductModel>();
		SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
		while(srs.next()) {
			productList.add(new ProductModel(srs.getInt("ID"), srs.getString("NAME"),
					srs.getFloat("PRICE"), srs.getString("DESCRIPTION")));
			}
		return productList;
	}
	
	//Creates a product.
	@Override
	public void create(ProductModel product) {
		String sql = "INSERT INTO PRODUCT (ID, NAME, PRICE, DESCRIPTION) VALUES (?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, product.getId(), product.getName(), product.getPrice(), product.getDescription());
	}
	
	@Override
	public void update(ProductModel product) {
		//
	}
	
	@Override
	public void delete(ProductModel product) {
		//
	}
}
