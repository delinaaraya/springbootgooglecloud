package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {
	//The properties for the product.
	@Min(value=1, message="Id must be 1 character")
	private int id;
	
	@Size(min=1, max=32, message="Product name must be between 1 and 32 characters")
	@NotNull(message="Product name is a required field")
	private String name;

	@Min(value=1, message="Price must be 1 character")
	@NotNull(message="Price is a required field")
	private float price;
	
	@Size(min=1, max=32, message="Description must be between 1 and 32 characters")
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
