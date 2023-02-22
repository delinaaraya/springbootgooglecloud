package com.gcu.data;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

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
		String sql = "SELECT * FROM Product";
		List<ProductModel> productList = new ArrayList<ProductModel>();
		SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
		while(srs.next()) {
			productList.add(new ProductModel(srs.getInt("id"), srs.getString("name"),
					srs.getFloat("price"), srs.getString("description")));
			}
		return productList;
	}
	
	//Creates a product.
	@Override
	public void create(ProductModel product) {
		String sql = "INSERT INTO Product (id, name, price, description) VALUES (?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, product.getId(), product.getName(), product.getPrice(), product.getDescription());
	}
	
	//@Override
	@SuppressWarnings("deprecation")
	public ProductModel findByID(int id) {
		String sql = "SELECT * FROM Product WHERE id = ?";
		return (ProductModel) jdbcTemplateObject.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<ProductModel>(ProductModel.class));
	}
	
	@Override
	public void update(ProductModel product) {
		String sql = "UPDATE Product SET name = ?, price = ?, desription = ? WHERE id = ?";
		jdbcTemplateObject.update(sql, product.getName(), product.getPrice(), product.getDescription(), product.getId());
	}
	
	@Override
	public void delete(ProductModel product) {
		String sql = "DELETE FROM Product WHERE id = ?";
		jdbcTemplateObject.update(sql, product.getId());
	}
}
