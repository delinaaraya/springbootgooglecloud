package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserLoginModel;
import com.gcu.model.ProductModel;
import com.gcu.business.ProductBusinessServiceInterface;

import java.util.*;

@Controller
@RequestMapping("/login/")
public class LoginController {
	
	@Autowired
	private ProductBusinessServiceInterface service;
	
	//Displays the login view.
	@GetMapping("")
	public String display(Model model) throws Exception
	{
		model.addAttribute("title", "Login");
		UserLoginModel login = new UserLoginModel();
		model.addAttribute("userLoginModel", login);
		//Temporary solution to ensure users are logged in without requiring the user to re-enter the required variables.
		/*
		login.setFname("Test");
		login.setLname("Test");
		login.setEmail("Test");
		login.setPhone(1234567890);
		*/
		return "login";
	}
	
	//Redirect user to the products page once login is successful.
	@PostMapping("/doLogin")
	public String doLogin(@Valid UserLoginModel userLoginModel, BindingResult bindingResult, Model model) throws Exception
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login");
			return "login";
		}
		List<ProductModel> products = service.getProducts();
		model.addAttribute("title", "Product List");
		model.addAttribute("products", products);
		System.out.println(String.format("Logged in as Username: %s \n Password: %s", userLoginModel.getUsername(), userLoginModel.getPassword()));
		return "products";
	}
}
