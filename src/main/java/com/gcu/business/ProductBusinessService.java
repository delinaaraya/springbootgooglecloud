package com.gcu.business;

import java.util.*;

import com.gcu.model.ProductModel;

public class ProductBusinessService implements ProductBusinessServiceInterface {

	@Override
	public List<ProductModel> getProducts() {
		List<ProductModel> productList = new ArrayList<ProductModel>();
		productList.add(new ProductModel(105, "Test", 10, "Test"));
		return productList;
	}
	@Override
	public void init() {
		System.out.println("In the ProductBusinessService.init()");
	}
	@Override
	public void destroy() {
		System.out.println("In the ProductBusinessService.destroy()");
	}
}
