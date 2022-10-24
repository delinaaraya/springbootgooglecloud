package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductBusinessService;
import com.gcu.model.ProductModel;


@Controller
@RequestMapping("/product/")
public class ProductController
{
	@Autowired
	private ProductBusinessService service;

	//Displays the new product view.
	@GetMapping("new")
	public String display(Model model)
	{
		model.addAttribute("title", "New Product Form");
		//UserModel registering = new UserRegistrationModel();
		model.addAttribute("productModel", new ProductModel());
		return "newproduct";
	}
	
	//Post request to add user data to the database and redirect the user to the products page.
	@PostMapping("doCreateProduct")
	public String doCreateProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "New Product Form");
			return "newproduct";
		}
		System.out.println(String.format("Product with Id of %d and Name of %s and Price of $%.02f and Description of %s ",
				productModel.getId(), 
				productModel.getName(), productModel.getPrice(), 
				productModel.getDescription()));
		service.addProduct(productModel);
		List<ProductModel> products = service.getProducts();
		model.addAttribute("title", "Product List");
		model.addAttribute("products", products);
		return "products";
	}
	
	//Redirect user to the products page once login is successful.
	@GetMapping("products")
	public String showProducts(Model model)
	{
		List<ProductModel> products = service.getProducts();
		model.addAttribute("title", "Product List");
		model.addAttribute("products", products);
		return "products";
	}
}