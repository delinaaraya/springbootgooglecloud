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

import com.gcu.business.ProductBusinessServiceInterface;
import com.gcu.data.RegisterDAO;
import com.gcu.model.ProductModel;
import com.gcu.model.UserRegistrationModel;

@Controller
@RequestMapping("/register/")
public class RegistrationController
{
	@Autowired
	private ProductBusinessServiceInterface service;
	
	@Autowired
	private RegisterDAO registerDao;

	//Displays the register view.
	@GetMapping("")
	public String display(Model model) throws Exception
	{
		model.addAttribute("title", "Registration Form");
		//UserModel registering = new UserRegistrationModel();
		model.addAttribute("userRegistrationModel", new UserRegistrationModel());
		return "register";
	}
	
	//Post request to add user data to the database and redirect the user to the products page.
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserRegistrationModel userRegistrationModel, BindingResult bindingResult, Model model) throws Exception
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Registration Form");
			return "register";
		}
		System.out.println(String.format("Form with Username of %s and Password of %s and First Name of %s and Last Name of %s and"
				+ " Email of %s and Phone Number of %d", userRegistrationModel.getUsername(), 
				userRegistrationModel.getPassword(), userRegistrationModel.getFname(), 
				userRegistrationModel.getLname(), userRegistrationModel.getEmail(), 
				userRegistrationModel.getPhone()));
		registerDao.create(userRegistrationModel);
		List<ProductModel> products = service.getProducts();
		model.addAttribute("title", "Product List");
		model.addAttribute("products", products);

		return "products";
	}
}