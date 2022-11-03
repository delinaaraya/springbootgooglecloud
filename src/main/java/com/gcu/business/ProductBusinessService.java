package com.gcu.business;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.ProductModel;

public class ProductBusinessService implements ProductBusinessServiceInterface {

	@Autowired
	DataAccessInterface<ProductModel> service;
	
	List<ProductModel> productList = new ArrayList<ProductModel>();
	@Override
	public List<ProductModel> getProducts() {
		//List<ProductModel> productList = new ArrayList<ProductModel>();
		//productList.add(new ProductModel(105, "Test", 10, "Test"));
		return service.findAll();
	}
	@Override
	public void init() {
		System.out.println("In the ProductBusinessService.init()");
	}
	@Override
	public void destroy() {
		System.out.println("In the ProductBusinessService.destroy()");
	}
	public void addProduct(ProductModel item) {
		//productList.add(new ProductModel(item.getId(), item.getName(), item.getPrice(), item.getDescription()));
		service.create(item);
		System.out.println(item.getId() + " " + item.getName() + " " + item.getPrice() + " " + item.getDescription());
	}
	
}
