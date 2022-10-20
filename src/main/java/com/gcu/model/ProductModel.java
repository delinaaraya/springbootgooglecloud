package com.gcu.model;

import javax.validation.constraints.NotNull;

public class ProductModel {
	//The properties for the product.
	private int id;
	
	@NotNull(message="Product name is a required field")
	private String name;

	@NotNull(message="Price is a required field")
	private float price;
	
	@NotNull(message="Description is a required field")
	private String description;
	
	//Getters and setters for the class variable.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductModel(int id, String name, float price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	//Empty class constructor.
	public ProductModel() {
		//this(0, " ", 0, " ");
	}
}
